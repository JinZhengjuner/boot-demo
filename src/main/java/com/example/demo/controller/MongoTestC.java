package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.MongoTest;
import com.example.demo.service.MongoTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
@Validated
@RestController
public class MongoTestC {
    @Autowired
    private MongoTestService mongoTestService;

    @PostMapping("/map")
    public String x(@RequestBody Map<String, String> map) {
        return JSON.toJSONString(map);
    }


    @GetMapping("/exception/test")
    public void exceptionTest() throws IOException {
        try {
            try {
                int a = 1 / 0;
            } catch (Exception e) {
                log.info("发生错误", e);
                throw new RuntimeException("出错了！！！！");
            }

        } catch (Exception e) {
            log.error("出错了");
            throw e;
        }
    }

    @GetMapping("/test/{id}/{name}")
    public String test(@PathVariable("id") String id, @PathVariable("name") String name) {
        return "test: ";
    }

    @GetMapping(value = "/update")
    public String update() {
        mongoTestService.update();
        return "update success";
    }

    @GetMapping(value = "/test1")
    public String saveTest() throws Exception {
        List<MongoTest> list = new ArrayList<MongoTest>();
        MongoTest mgtest = new MongoTest();
        mgtest.setId(11);
        mgtest.setAge(33);
        mgtest.setName("测试");
        list.add(mgtest);
        mongoTestService.saveTest(mgtest);

        return "success";

    }

    @GetMapping(value = "/test2")
    public MongoTest findTestByName() {
        MongoTest mgtest = mongoTestService.findTestByName("测试");
        System.out.println("mgtest is " + mgtest);
        return mgtest;
    }

    @GetMapping(value = "/test3")
    public void updateTest() {
        MongoTest mgtest = new MongoTest();
        mgtest.setId(11);
        mgtest.setAge(44);
        mgtest.setName("ceshi2");
        mongoTestService.updateTest(mgtest);
    }

    @GetMapping(value = "/test4")
    public void deleteTestById() {
        mongoTestService.deleteTestById(11);
    }

    @GetMapping(value = "/batchInsert")
    public String batchInsert() {
        return mongoTestService.batchInsert();
    }

}

