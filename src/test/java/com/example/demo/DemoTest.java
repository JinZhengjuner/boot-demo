package com.example.demo;

import com.alibaba.fastjson2.JSON;
import com.example.demo.config.ThresholdConfig;
import com.example.demo.pojo.StockFlowLog;
import com.example.demo.pojo.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoTest {

    @Autowired
    private ThresholdConfig config;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void testMongo(){
        BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, User.class);
        List<User> userList = new ArrayList<>();
        userList.add(new User("001", "Alice", Arrays.asList("a","b"),1D));
        userList.add(new User("002", "Bob", Arrays.asList("c","d"),2.4D));
        bulkOps.insert(userList);

        Query query = new Query(Criteria.where("name").is("张三"));
        Update update = new Update().set("name", "张三更新了").set("age", 21);
        bulkOps.updateOne(query, update);

        Query query1 = new Query(Criteria.where("name").is("李四"));
        Update update1 = new Update().set("name", "李四更新了").set("age", 21).set("qty",0.1D);
        bulkOps.updateOne(query1, update1);

        bulkOps.execute();
    }


    @Before
    public void setUp() throws Exception {
    }
    @Test
    @SneakyThrows
    public void config(){


    }

    @Test
    public void add() {
        List<StockFlowLog> flowLogList = new ArrayList<>();
        flowLogList.add(new StockFlowLog("张三", ""));
        flowLogList.add(new StockFlowLog("李四", "2"));
        flowLogList.add(new StockFlowLog("王五", "3"));
//        flowLogList = flowLogList.stream().filter(stockFlowLog -> {
//            if (StringUtils.isEmpty(stockFlowLog.getQty())) {
//                log.error("库存流水解析qty为空，fileName: {}, stockFlow:{}", JSON.toJSONString(stockFlowLog));
//                return false;
//            } else {
//                return true;
//            }
//        }).collect(Collectors.toList());

         flowLogList.removeIf(stockFlowLog -> {
            if (StringUtils.isEmpty(stockFlowLog.getQty())) {
                log.error("库存流水解析qty为空，fileName: {}, stockFlow:{}", JSON.toJSONString(stockFlowLog));
                return true;
            }
            return false;
        });
        System.out.println(flowLogList);
    }
}