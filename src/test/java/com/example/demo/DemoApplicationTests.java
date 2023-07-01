package com.example.demo;


import com.alibaba.excel.EasyExcel;
import com.example.demo.pojo.StockCheck;
import com.example.demo.pojo.Student;
import com.example.demo.service.MyRedisService;
import com.example.demo.strategy.BaseHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DemoApplicationTests {

    @Resource(name = "myRedisServiceImpl01")
    private MyRedisService myRedisService;

    @Resource
    private Student student;

    @Autowired
    private Map<String, BaseHandler> handlerMap;

    @Value("${my}")
    private String val;



    @Test
    public void sss() throws  ParseException {
        System.out.println(val);
    }




    @Test
    public void sss1() throws IOException {
        File file = new File("a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write("Hello World".getBytes());
        fileOutputStream.close();

        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int len = fis.read(buffer);
        while (len != -1) {
            System.out.write(buffer, 0, len);
            len = fis.read(buffer);
        }
        fis.close();


    }



    @Test
    public void artimethTest() throws IOException {
        List<StockCheck> stockCheckList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            StockCheck stockCheck = new StockCheck(Long.valueOf(i),"itemCode" + i, "barCode" +i,Double.valueOf(i),Double.valueOf(i+1),Long.valueOf(999+i), Long.valueOf(888+i),"asd"+i);
            stockCheckList.add(stockCheck);
        }

        String filePath =  "/Users/jinzhengjun/IdeaProjects/demo/src/main/resources/tmp/a.xlsx";
        File file = new File(filePath);
        if (!file.exists()) file.createNewFile();


        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        EasyExcel.write(file, StockCheck.class)
                .sheet("用户信息")
                .doWrite(stockCheckList);





    }


    @Test
    public void test(){
        List<String> list = new ArrayList<>();

        System.out.println(CollectionUtils.isEmpty(list));
        System.out.println(list.size());
        System.out.println(list.size() < 100);
    }


    @Test
    public void contextLoads() {
//        Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent("a", LocalDateTime.now() + "_a12345", 1l, TimeUnit.MINUTES);
//        System.out.println(ifAbsent);
//        String str = null;
//        log.info("str:{}", str);

        try {
            int i = 1/0;
        }catch (Exception e){
            log.error("校验失败", e);
        }



    }


}
