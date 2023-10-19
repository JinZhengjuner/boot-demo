package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@Validated
@RestController
public class MongoTestC {


    @Scheduled(cron = "01 * 0/1 * * ?")
    public void sss() throws InterruptedException {
        log.info("执行了");
        log.info("执行完毕");
    }



}

