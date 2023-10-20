package com.example.demo.controller.test;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class B {
    @JSONField(name = "a")
    private String name;

    private String address;

    public static void main(String[] args) {
        //2
        //1
    //正确的

    }

}
