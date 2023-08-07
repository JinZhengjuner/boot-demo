package com.example.demo;

import com.alibaba.fastjson2.JSON;
import com.example.demo.config.ThresholdConfig;
import com.example.demo.pojo.StockFlowLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DemoTest {

    @Autowired
    private ThresholdConfig config;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void config(){
        log.info("xx");
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