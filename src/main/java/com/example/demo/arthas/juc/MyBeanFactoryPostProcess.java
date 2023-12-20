package com.example.demo.arthas.juc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


@Component
public class MyBeanFactoryPostProcess implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("car");

    }

    public static void main(String[] args) {
        String strDate = "2023-11-20 00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(strDate, formatter);

        // 转换为 Instant
        Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();

        // 获取时间戳（毫秒）
        long timeStamp = instant.toEpochMilli();
        System.out.println("时间戳是：" + timeStamp);
    }
}
