package com.example.demo.config;

import com.example.demo.pojo.Student;
import com.example.demo.service.MyRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.PostConstruct;

@Configuration
public class MyTestConfig {

    @Autowired
    private MyRedisService myRedisServiceImpl01;

    @Bean("aaastudent")
    public Student getStudent(){
        Student student = new Student(1l, "spring创建的我", 1l, 1l);
        return student;
    }

    @Bean("bbbtudent")
    @Primary
    public Student getStudentb(){
        Student student = new Student(1l, "spring创建的我bbbb", 1l, 1l);
        return student;
    }

    @PostConstruct
    public void test(){
        System.out.println();
    }




}
