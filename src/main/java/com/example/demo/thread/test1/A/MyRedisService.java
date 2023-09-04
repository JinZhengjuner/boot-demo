package com.example.demo.thread.test1.A;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redisson")
@Slf4j
public class MyRedisService {

    @Resource
    private RedissonClient redissonClient;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/string/{num}")
    public String testString(@PathVariable("num") int num){

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            Boolean ifAbsent = stringRedisTemplate.opsForValue().setIfAbsent(String.valueOf(i), "num" + i, 5L, TimeUnit.SECONDS);
        }
        Long total = System.currentTimeMillis() - startTime;
        Long avg = total / num;
        String result = "总耗时: "+ total +", 平均耗时：" + avg;
        log.info(result);
        return result;


    }

    @GetMapping("/{a}")
    public String test(@PathVariable("a")String a) throws InterruptedException {
        //批量设置库存状态
        return "";
    }}

//    @GetMapping("b/{num}")
//    public String testB(@PathVariable("num") int num) throws InterruptedException {
////        RLock lock = redissonClient.getLock("A");
////        lock.lock(10L, TimeUnit.SECONDS);
////        log.info("bbbbb上锁");
////        Thread.sleep(20000);
////        log.info("是否当前线程持有：" + lock.isHeldByCurrentThread());
////        log.info("解锁");
////        lock.unlock();
////        return "b";
//        ExecutorService executorService = Executors.newFixedThreadPool(50);
//        long startTime = System.currentTimeMillis();
//        List<CompletableFuture<Void>> futuresOne = new ArrayList<>();
//        for (int i = 0; i < num; i++) {
//            int s = i;
//            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//                RLock lock = redissonClient.getLock(String.valueOf(s));
//                lock.lock(5L, TimeUnit.SECONDS);
//            });
//            futuresOne.add(completableFuture);
////        }
////        futuresOne.stream().f
//        String result = num +" 把锁总共耗时：" + (System.currentTimeMillis()-startTime);
//        for (int i = 0; i < num; i++) {
//            int s = i;
//            executorService.submit(()->{
//                RLock lock = redissonClient.getLock(String.valueOf(s));
//                lock.unlock();
//            });
//        }
//
//
//        log.info(result);
//        Long total = System.currentTimeMillis()-startTime;
//        long avg = total / num;
//
//        String result1 = num +" 总共耗时：" + total + " 平均耗时: " + avg;
//
//        return result1;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        new Thread().start();
//    }
//
//    private static void m1() {
//        ExecutorService executorSece = Executors.newFixedThreadPool(50);
//
//        CompletableFuture<Void>[] futures = new CompletableFuture[50];
//        List<CompletableFuture<Void>> list  = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            int num = i;
//            list.add(CompletableFuture.runAsync(() -> {
//                try {
//                    Thread.sleep(num * 100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                log.info("第" + num + "个线程执行了！");
//            }, executorSece));
//        }
//
//        list.forEach(future -> {
//            try {
//                future.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });
//
////        CompletableFuture.allOf(futures).thenRun(()->
//        log.info("所有操作执行完毕");
////        );
//        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(futures);
//
//    }
//
//
//}
