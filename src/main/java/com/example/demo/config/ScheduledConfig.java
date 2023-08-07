//package com.example.demo.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.TaskScheduler;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//
//@Configuration
//public class ScheduledConfig {
//    @Bean
//    public TaskScheduler taskScheduler() {
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        //最大线程数
//        taskScheduler.setPoolSize(30);
//        return taskScheduler;
//    }
//
//}
