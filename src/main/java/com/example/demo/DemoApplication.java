package com.example.demo;

import com.example.demo.arthas.juc.Car;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
//@EnableAsync
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.example.demo.arthas.juc"})
public class DemoApplication {

    @Resource
    private Car car;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("car");
    }

}
