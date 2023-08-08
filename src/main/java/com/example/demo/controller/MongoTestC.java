package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.demo.config.ThresholdConfig;
import com.example.demo.pojo.MongoTest;
import com.example.demo.service.MongoTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


@Slf4j
@Validated
@RestController
public class MongoTestC {
    @Autowired
    private MongoTestService mongoTestService;

//    @Scheduled(fixedRate = 50 * 1000)
////    @Async
//    public void sss() throws InterruptedException {
//        log.info("执行了");
//        Thread.sleep(1500);
//        log.info("执行完毕");
//    }

    @Autowired
    private ThresholdConfig thresholdConfig;

    public static void main(String[] args) throws InterruptedException {
//        List<Integer> list = new ArrayList<>();
//        List<Integer> collect = Optional.ofNullable(list)
//                .orElse(Collections::emptyList)
//                .stream()
//                .filter(StringUtils::isEmpty)
//                .collect(Collectors.toList());

        for (int i = 0; i < 100; i++) {
            int j = (int)(Math.random() * 5 + 5);
            log.info(j+"");
        }



    }

    @RequestMapping("/A")
    public String testA() throws InterruptedException {
        String appIdToThresholdStr = thresholdConfig.getAppIdToThresholdStr();
        Map<String, String> appIdToThresholdMap = JSON.parseObject(appIdToThresholdStr, new TypeReference<HashMap<String, String>>(){});
//        sss();
        return "success";
    }

//    @GetMapping("/A")
//    public String A2(@RequestBody A a,String d,String e){
//        return a + d + e;
//    }

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

    @GetMapping(value = "/test/update")
    public String update(long EntId, String regionCode, String barcode, String itemCode, double num) {
        Query query = new Query(Criteria.where("ent_id").is(EntId)
                .and("barcode").is(barcode).and("item_code").is(itemCode).and("region_code").is(regionCode));
        Update update = new Update();
        update.inc("available_qty", num);
        update.set("timestamp", new Date());
        mongoTestService.update();
        return "更新成功1";
    }


}

