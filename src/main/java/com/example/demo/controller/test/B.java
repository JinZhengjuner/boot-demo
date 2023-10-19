package com.example.demo.controller.test;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class B {
    @JSONField(name = "a")
    private String name;

    private String address;

    public static void main(String[] args) {
        //等会儿回滚到这里就正确了
        System.out.println(StringUtils.isEmpty("   "));
        System.out.println(StringUtils.isBlank("   "));
    }
}
