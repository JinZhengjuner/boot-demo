//package com.example.demo.service.impl;
//
//
//import com.example.demo.pojo.MongoTest;
//import com.example.demo.service.MongoTestService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//@Service("TestService")
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
//public class MongoTestServiceImpl implements MongoTestService {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    private Map<Integer, Integer> map = new HashMap<>();
//
//    private static Integer i = 1;
//
//    /**
//     * 创建对象
//     */
//    @Override
//    public void saveTest(MongoTest test){
//        mongoTemplate.save(test);
//    }
//
//    /**
//     * 根据用户名查询对象
//     * @return
//     */
//    @Override
//    public MongoTest findTestByName(String name) {
//        Criteria criteria = Criteria.where("name").is(name);
//        criteria.and("xxx").is(null);
//        Query query=new Query(criteria);
//        MongoTest mgt =  mongoTemplate.findOne(query , MongoTest.class);
//        return mgt;
//    }
//
//    /**
//     * 更新对象
//     */
//    @Override
//    public void updateTest(MongoTest test) {
//        Query query=new Query(Criteria.where("id").is(test.getId()));
//        Update update= new Update().set("age", test.getAge()).set("name", test.getName());
//        //更新查询返回结果集的第一条
//        mongoTemplate.updateFirst(query,update,MongoTest.class);
//        //更新查询返回结果集的所有
//        // mongoTemplate.updateMulti(query,update,TestEntity.class);
//    }
//
//    /**
//     * 删除对象
//     * @param id
//     */
//    @Override
//    public void deleteTestById(Integer id) {
//        Query query=new Query(Criteria.where("id").is(id));
//        mongoTemplate.remove(query,MongoTest.class);
//    }
//
//    @Override
//    public String batchInsert() {
//        List<MongoTest> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            MongoTest mongoTest = new MongoTest();
//            mongoTest.setId(i);
//            mongoTest.setSortId(Long.valueOf(i));
//            mongoTest.setAge(i);
//            mongoTest.setSex("男");
//            mongoTest.setName("jzj"+i);
//            mongoTest.setAddress("成都"+i);
//            list.add(mongoTest);
//        }
//
//        try {
//            mongoTemplate.insertAll(list);
//        }catch (Exception e){
//            throw e;
//        }
//
//        return "success";
//    }
//
//    @Override
//    public void exceptionTest() {
//        System.out.println("jinlaile");
//        map.put(i, i++);
//        System.out.println(map);
//    }
//
//    @Override
//    public void update() {
//        Query query = new Query(Criteria.where("name").is("jinzhengjun").and("address").is("chengdu").and("age").is(5));
//        Update update = new Update();
//        update.set("updateTime", new Date());
//        update.set("age",18);
//        mongoTemplate.updateFirst(query, update, "test");
//    }
//}
