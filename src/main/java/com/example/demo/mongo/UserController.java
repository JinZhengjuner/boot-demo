//package com.example.demo.mongo;
//
//import com.alibaba.fastjson2.JSON;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/user/")
//public class UserController {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @GetMapping("/insert")
//    public String insert(){
//        User user = new User();
//        user.setName("jinzhengjun");
//        user.setAge(18);
//        mongoTemplate.insert(user, "users");
//        return JSON.toJSONString(user);
//    }
//
//    @GetMapping("/update")
//    public String update(){
//        User user = new User();
//        user.setName("jinzhengjun");
//        user.setAge(18);
//        Query userQuery = new Query(Criteria.where("name").is("jinzhengjun").and("age").is(18));
//        Update userUpdate = new Update();
//        userUpdate.set("name","jinzhengjun");
//        userUpdate.set("add","add1");
//        mongoTemplate.updateMulti(userQuery, userUpdate, "users");
//        return JSON.toJSONString(user);
//    }
//
//
//
//
//}
