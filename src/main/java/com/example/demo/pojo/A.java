package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class A {
    private String a;
    private String b;
    private String c;
    @NotEmpty(message = "list不能为空")
    private List<Integer> list;
}
