package com.example.demo.service.impl;

import com.example.demo.service.MyRedisService;
import org.springframework.stereotype.Service;

@Service
public class MyRedisServiceImpl02 implements MyRedisService {
    @Override
    public void sayYou() {
        System.out.println("我是02～～～～～～");
    }
}
