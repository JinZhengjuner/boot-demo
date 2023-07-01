package com.example.demo.strategy;


import org.springframework.stereotype.Component;

@Component("division")
public class DivisionHandler implements BaseHandler {

    @Override
    public double arithmetic(int startNum, int endNum) {
        return startNum / endNum;
    }
}
