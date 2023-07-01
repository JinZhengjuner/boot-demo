package com.example.demo.strategy;


import org.springframework.stereotype.Component;

@Component("addition")
public class AdditionHandler implements BaseHandler {

    @Override
    public double arithmetic(int startNum, int endNum) {
        return startNum + endNum;
    }
}
