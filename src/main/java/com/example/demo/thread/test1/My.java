package com.example.demo.thread.test1;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class My extends Thread {
    private String age;
    private int score;

    public My(String age, int score) {
        this.age = age;
        this.score = score;
    }

    @Override
    public void run() {
        System.out.println(age + " is studying...");
        try {
            // 模拟学习过程
            Thread.sleep(score * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(age + " has finished studying.");
    }

    public static void main(String[] args) {
        My s1 = new My("Tom", 5);
        My s2 = new My("Jerry", 3);
        s1.start();
        s2.start();
    }


}
