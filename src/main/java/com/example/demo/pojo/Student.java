package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private long id;
    private String name;
    private long sno;
    private long age;
    private static int num;

    public static void main(String[] args) {
        Set<String> set = null;
        System.out.println(set.isEmpty());


    }




}
