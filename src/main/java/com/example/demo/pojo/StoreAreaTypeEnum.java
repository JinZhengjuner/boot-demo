package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
@Getter
public enum StoreAreaTypeEnum {
    ONE(1,"系统区域"),
    TWO(2,"品类区域"),
    THREE(3,"自定义区域");

    private final Integer code;
    private final String name;

    public static void main(String[] args) {
        List<String> list = null;
        for (String s : list) {
            System.out.println();
        }
    }

    public static String getStoreTypeNameByCode(Integer code){
        String str = "AaBb";
        System.out.println(testFunc(String::toLowerCase, str));
        System.out.println(testFunc(String::toUpperCase, str));
        return "";
    }


    public static String testFunc(Function<String, String> function, String old){
        return "---" + function.apply(old) + "---";
    }
}
