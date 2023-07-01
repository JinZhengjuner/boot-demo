package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component("multiplication")
public class MultiplicationHandler implements BaseHandler {

    @Override
    public double arithmetic(int startNum, int endNum) {
        return startNum * endNum;
    }
}
