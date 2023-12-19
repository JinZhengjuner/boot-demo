package com.example.demo.controller.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

@Data
@AllArgsConstructor
public class TestA {
    private String name;
    private String address;

    public static void main(String[] args) {
        Pair<String, Integer> pair = Pair.of("aaa", 1);
        System.out.println(pair.getKey());
        Integer value = pair.getValue();
        System.out.println(value);
    }


}


