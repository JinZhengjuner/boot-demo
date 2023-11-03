package com.example.demo.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.util.List;

@Data
@Slf4j
public class A {
    private String a;
    private String b;
    private String c;
    @NotEmpty(message = "list不能为空")
    private List<Integer> list;

    public static void main(String[] args) throws IOException {
        String storeTypeNameByCode = StoreAreaTypeEnum.getStoreTypeNameByCode(5);
        System.out.println(storeTypeNameByCode);
    }
}
