package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    int a;
    public volatile int m1 = 1;
    public volatile int m2 = 2;

    public  void ss() {
        int i = m1;
        int j = m2;

        a =i + j;
        m1 = j + 1;
        m2 = j + 2;

    }
}