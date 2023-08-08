package com.example.demo.zongjie.lingpaitong;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("limit")
public class GuavaRateLimit {

    static RateLimiter limiter = RateLimiter.create(2);

    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(new SimpleDateFormat("HH:mm:ss:Sss").format(new Date()));
        }
    }

    @GetMapping("/test/{num}")
    public void a(@PathVariable("num")int num){
        limiter.acquire(num);
        log.info("success,{}", num);
    }


    public static void main(String[] args) {
        double waitTime = limiter.acquire(20);
        log.info("xxx");
        limiter.acquire(20);
        log.info("2222");
        new Thread(() -> {
            limiter.acquire(20);
            log.info("new");
        }).start();

//        for (int i = 0; i < 5; i++) {
//            double acquire = limiter.acquire();
//            System.out.println(i + "---" + acquire + "------" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
////            new Thread(new Task()).start();
////            System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
//        }


//        // 每秒生成5个令牌
//        RateLimiter limiter = RateLimiter.create(50.0);
//
//        for (int i = 0; i < 20; i++) {
//            // 获取令牌
//            double waitTime = limiter.acquire(20);
//            log.info("xxx");
//        }


    }

    private static void 吗() {
        Collection<String> tasks = Arrays.asList("1", "2", "3", "4");
        String[] values = tasks.toArray(new String[0]);
        System.out.println(values);
    }
}
