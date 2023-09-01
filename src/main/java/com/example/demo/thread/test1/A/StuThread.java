package com.example.demo.thread.test1.A;

import lombok.Data;

@Data
public class StuThread extends Thread{
    private String stuName;

    @Override
    public void run() {
        System.out.println("StuThread run..." + Thread.currentThread().getName());
    }
}
