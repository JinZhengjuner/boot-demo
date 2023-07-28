package com.example.demo.zongjie.lingpaitong;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GuavaRateLimit {

    static RateLimiter limiter = RateLimiter.create(2);

    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(new SimpleDateFormat("HH:mm:ss:Sss").format(new Date()));
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            double acquire = limiter.acquire();
            System.out.println(i + "---" + acquire + "------" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
//            new Thread(new Task()).start();
//            System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }


//        // 每秒生成5个令牌
//        RateLimiter limiter = RateLimiter.create(50.0);
//
//        for (int i = 0; i < 20; i++) {
//            // 获取令牌
//            double waitTime = limiter.acquire();
//            System.out.println("获取令牌，等待时间：" + waitTime);
//        }

    }
}
