package com.example.demo.controller.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class B {
    @JSONField(name = "a")
    private String a;

    public static void main(String[] args) {
        String str = "{\"A\":\"_aaa___\",\"a\":\"aaa\"}";
        B b1 = JSON.parseObject(str, B.class);
        System.out.println(b1);
    }
}
