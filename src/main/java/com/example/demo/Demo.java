package com.example.demo;

import com.example.demo.pojo.ConsumerMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo {
    //新建一个测试方法
    public int add(int a,  int b){
        return a + b;
    }

    public static void main(String[] args) {


        ConsumerMessage consumerMessage = new ConsumerMessage();
//        consumerMessage.setStoreTimestamp(System.currentTimeMillis()- 1000*60*60*24);
        Optional.ofNullable(consumerMessage)
                .map(ConsumerMessage::getStoreTimestamp)
                .map(storeTimestamp -> (System.currentTimeMillis() - storeTimestamp) / 1000.0D)
                .ifPresent(delay -> {
                    System.out.println("执行了");
                });
        List<Integer> list = Arrays.asList(1,2,3,4,5,98,5,53,3);

        List<String> collect = list.stream()
                         .filter(x -> x > 4)
                .map(x -> String.valueOf(x))
                .collect(Collectors.toList());
    }
}
