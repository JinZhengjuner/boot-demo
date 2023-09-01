package com.example.demo.thread.test1.A;

import lombok.Data;

@Data
public class StuRunnable implements Runnable {

    private String stuName;

    @Override
    public void run() {
        System.out.println("StuRunnable run ..." + Thread.currentThread().getName());
    }

}
