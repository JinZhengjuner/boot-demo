//package com.example.demo.thread.test1.A;
//
//import lombok.extern.slf4j.Slf4j;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.*;
//
//@RestController
//@RequestMapping("/redisson")
//@Slf4j
//public class MyRedisService {
//
//    @Resource
//    private RedissonClient redissonClient;
//
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//
//    @GetMapping("/string/{num}")
//    public String testString(@PathVariable("num") int num) {
//        Long startTime = System.currentTimeMillis();
//        for (int i = 0; i < num; i++) {
//            Boolean ifAbsent = stringRedisTemplate.opsForValue().setIfAbsent(String.valueOf(i), "num" + i, 5L, TimeUnit.SECONDS);
//        }
//        Long total = System.currentTimeMillis() - startTime;
//        Long avg = total / num;
//        String result = "总耗时: " + total + ", 平均耗时：" + avg;
//        log.info(result);
//        return result;
//    }
//
//
//    @GetMapping("b/{num}")
//    public String testB(@PathVariable("num") int num) throws InterruptedException {
//
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        long startTime = System.currentTimeMillis();
//        List<CompletableFuture<Void>> futuresOne = new ArrayList<>();
//        for (int i = 0; i < num; i++) {
//            int s = i;
//            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//                RLock lock = redissonClient.getLock(String.valueOf(s));
//                lock.lock(5L, TimeUnit.SECONDS);
//                lock.unlock();
//            }, executorService);
//            futuresOne.add(completableFuture);
//
//        }
//
//        futuresOne.forEach(x -> {
//            try {
//                x.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });
//        String result = num + " 把锁总共耗时：" + (System.currentTimeMillis() - startTime);
//        log.info(result);
//        Long total = System.currentTimeMillis() - startTime;
//        long avg = total / num;
//        String result1 = num + " 总共耗时：" + total + " 平均耗时: " + avg;
//        return result1;
//    }
//    }
