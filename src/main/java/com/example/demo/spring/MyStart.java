package com.example.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.Map;
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

    //获取bean
    public static Object getBean(String beanName) throws InstantiationException, IllegalAccessException {
        Object singleton = getSingleton(beanName);
        if (singleton != null){
            return singleton;
        }

        //实例化
        RootBeanDefinition beanDefinition = (RootBeanDefinition) beanDefinitionMap.get(beanName);
        Class<?> beanClass = beanDefinition.getBeanClass();
        Object instanceBean = beanClass.newInstance();

        //创建动态代理,这里二级缓存也可以解决动态代理，但是spring还是希望初始化后再进行动态代理
        instanceBean = new JdkProxyBeanPostProcessor().getEarlyBeanReference(instanceBean, beanName);
        earlySingletonObjects.put(beanName, instanceBean);
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
        singletonObjects.put(beanName, instanceBean);
        return instanceBean;
    }

    private static Object getSingleton(String beanName) {
        if (singletonObjects.containsKey(beanName)){
            return singletonObjects.get(beanName);
        }else if (earlySingletonObjects.containsKey(beanName)){
            return earlySingletonObjects.get(beanName);
        }
        return null;
    }
}
