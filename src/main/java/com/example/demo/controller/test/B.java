package com.example.demo.controller.test;

import lombok.Data;

@Data
public class B {

    public B() {
        System.out.println("无参构造执行了");
    }

    private String name;

    {
        System.out.println("代码框执行了");
    }

}
