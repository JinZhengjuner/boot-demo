package com.example.demo.thread.test1.A;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void doSomething() {
        // 获取需要使用的 Bean
        MyBean someBean = applicationContext.getBean(MyBean.class);
        // 在 Bean 中进行相关操作

    }
}
