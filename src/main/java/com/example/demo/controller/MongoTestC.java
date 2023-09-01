//package com.example.demo.controller;
//
//
//import com.alibaba.fastjson.JSON;
//import com.example.demo.config.ThresholdConfig;
//import com.example.demo.pojo.MongoTest;
//import com.example.demo.service.MongoTestService;
//import com.example.demo.thread.test1.A.AppContextUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//
//@Slf4j
//@Validated
//@RestController
//public class MongoTestC {
//    @Autowired
//    private MongoTestService mongoTestService;
//
////    @Scheduled(fixedRate = 50 * 1000)
//////    @Async
////    public void sss() throws InterruptedException {
////        log.info("执行了");
////        Thread.sleep(1500);
////        log.info("执行完毕");
////    }
//
//    @Autowired
//    private ThresholdConfig thresholdConfig;
//
//
//
//
//    @RequestMapping("/A")
//    public String testA() throws InterruptedException {
//        ApplicationContext applicationContext = AppContextUtil.getApplicationContext();
//        return "success";
//    }
//
//    private void a() throws InterruptedException {
//        Thread.sleep(1000);
//    }
//
//    @RequestMapping("/B")
//    public void testB() throws InterruptedException {
//        while (true){
//            System.out.println("BBBBB");
//        }
//
//    }
//
////    @GetMapping("/A")
////    public String A2(@RequestBody A a,String d,String e){
////        return a + d + e;
////    }
//
//    @PostMapping("/map")
//    public String x(@RequestBody Map<String, String> map) {
//        return JSON.toJSONString(map);
//    }
//
//
//    @GetMapping("/exception/test")
//    public void exceptionTest() throws IOException {
//        try {
//            try {
//                int a = 1 / 0;
//            } catch (Exception e) {
//                log.info("发生错误", e);
//                throw new RuntimeException("出错了！！！！");
//            }
//
//        } catch (Exception e) {
//            log.error("出错了");
//            throw e;
//        }
//    }
//
//    @GetMapping("/test/{id}/{name}")
//    public String test(@PathVariable("id") String id, @PathVariable("name") String name) {
//        return "test: ";
//    }
//
//    @GetMapping(value = "/update")
//    public String update() {
//        mongoTestService.update();
//        return "update success";
//    }
//
//    @GetMapping(value = "/test1")
//    public String saveTest() throws Exception {
//        List<MongoTest> list = new ArrayList<MongoTest>();
//        MongoTest mgtest = new MongoTest();
//        mgtest.setId(11);
//        mgtest.setAge(33);
//        mgtest.setName("测试");
//        list.add(mgtest);
//        mongoTestService.saveTest(mgtest);
//
//        return "success";
//
//    }
//
//    @GetMapping(value = "/test2")
//    public MongoTest findTestByName() {
//        MongoTest mgtest = mongoTestService.findTestByName("测试");
//        System.out.println("mgtest is " + mgtest);
//        return mgtest;
//    }
//
//    @GetMapping(value = "/test3")
//    public void updateTest() {
//        MongoTest mgtest = new MongoTest();
//        mgtest.setId(11);
//        mgtest.setAge(44);
//        mgtest.setName("ceshi2");
//        mongoTestService.updateTest(mgtest);
//    }
//
//    @GetMapping(value = "/test4")
//    public void deleteTestById() {
//        mongoTestService.deleteTestById(11);
//    }
//
//    @GetMapping(value = "/batchInsert")
//    public String batchInsert() {
//        return mongoTestService.batchInsert();
//    }
//
//    @GetMapping(value = "/test/update")
//    public String update(long EntId, String regionCode, String barcode, String itemCode, double num) {
//        Query query = new Query(Criteria.where("ent_id").is(EntId)
//                .and("barcode").is(barcode).and("item_code").is(itemCode).and("region_code").is(regionCode));
//        Update update = new Update();
//        update.inc("available_qty", num);
//        update.set("timestamp", new Date());
//        mongoTestService.update();
//        return "更新成功1";
//    }
//
//
//}
//
