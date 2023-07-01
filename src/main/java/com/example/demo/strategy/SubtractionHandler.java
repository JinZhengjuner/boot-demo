package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component("subtraction")
public class SubtractionHandler implements BaseHandler {

    @Override
    public double arithmetic(int startNum, int endNum) {
        return startNum + endNum;
    }
}
