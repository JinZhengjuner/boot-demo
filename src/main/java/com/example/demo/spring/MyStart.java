package com.example.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MyStart {
    private static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    /**
     * 读取bean定义，当然在spring中肯定是根据配置 动态扫描注册
     */
    public static void loadBeanDefinitions() {
        RootBeanDefinition aBeanDefinition=new RootBeanDefinition(InstanceA.class);
        RootBeanDefinition bBeanDefinition=new RootBeanDefinition(InstanceB.class);
        beanDefinitionMap.put("instanceA",aBeanDefinition);
        beanDefinitionMap.put("instanceB",bBeanDefinition);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        loadBeanDefinitions();
        for (String key : beanDefinitionMap.keySet()) {

            //先创建A
            if ("instanceA".equals(key)){
                getBean(key);

            }
        }
        InstanceA instanceA = (InstanceA) getBean("instanceA");
        instanceA.say();
    }

    public static Map<String, Object> singletonObjects = new ConcurrentHashMap<>();
    public static Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>(); //二级缓存存放不完整Bean，避免读取到不完整的bean

    public static Map<String, ObjectFactory> singletonFactory = new ConcurrentHashMap<>(); //三级缓存就是为了解耦，为了单一职责，二级缓存就可以解决循环依赖

    public static Set<String> singletonCurennlyInCreation = new HashSet<>();

    //获取bean
    public static Object getBean(String beanName) throws InstantiationException, IllegalAccessException {
        Object singleton = getSingleton(beanName);
        if (singleton != null){
            return singleton;
        }

        //标记正在创建
        if (!singletonCurennlyInCreation.contains(beanName)){
            singletonCurennlyInCreation.add(beanName);
        }
        Object instanceBean = null;
        synchronized (singletonObjects){
            //实例化
            RootBeanDefinition beanDefinition = (RootBeanDefinition) beanDefinitionMap.get(beanName);
            Class<?> beanClass = beanDefinition.getBeanClass();
            instanceBean = beanClass.newInstance();

            //说明是循环依赖
            //创建动态代理,这里二级缓存也可以解决动态代理，但是spring还是希望初始化后再进行动态代理
            // 只在循环依赖的情况下在实例化后创建proxy，
            // 怎么判断是否是循环依赖？：二级缓存中有就是循环依赖
            singletonFactory.put(beanName, () -> new JdkProxyBeanPostProcessor().getEarlyBeanReference(earlySingletonObjects.get(beanName), beanName));

            //属性赋值
            Field[] declaredFields = beanClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                Autowired annotation = declaredField.getAnnotation(Autowired.class);
                /*属性上面有注解*/
                if (annotation != null){
                    declaredField.setAccessible(true);
                    //spring中是:byName byType byConstruct
                    Object fileObject = getBean(declaredField.getName()); //拿到B的bean
                    declaredField.set(instanceBean, fileObject);
                }
            }
            //初始化  inial... @postconstruct 略 ....
            //添加到一级缓存

            if (earlySingletonObjects.containsKey(beanName)){
                instanceBean = earlySingletonObjects.get(beanName);
            }
            singletonObjects.put(beanName, instanceBean);
        }

        return instanceBean;
    }

    private static Object getSingleton(String beanName) {
        Object bean = singletonObjects.get(beanName);
        /*循环依赖 */
        if (bean==null && singletonCurennlyInCreation.contains(beanName)){
           synchronized (singletonObjects){
               if (earlySingletonObjects.containsKey(beanName)){
                   return earlySingletonObjects.get(beanName);
               }
               ObjectFactory objectFactory = singletonFactory.get(beanName);
               if (objectFactory != null){
                   Object object = objectFactory.getObject();//得到proxyObject
                   earlySingletonObjects.put(beanName, object);
                   return object;
               }
           }
        }

        if (singletonObjects.containsKey(beanName)){
            return singletonObjects.get(beanName);
        }else if (earlySingletonObjects.containsKey(beanName)){
            return earlySingletonObjects.get(beanName);
        }
        return null;
    }
}
