package com.example.demo.thread.test1.A;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/redisson")
@Slf4j
public class MyRedisService {

    @Resource
    private RedissonClient redissonClient;

    @GetMapping("/{a}")
    public String test(@PathVariable("a")String a) throws InterruptedException {
        //批量设置库存状态
        return "";
    }

    @GetMapping("b")
    public String testB(){
        RLock lock = redissonClient.getLock("A");
        lock.lock();
        log.info("bbbbb上锁");
        lock.unlock();
        return "b";
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        new Thread().start();
    }

    private static void m1() {
        ExecutorService executorSece = Executors.newFixedThreadPool(50);

        CompletableFuture<Void>[] futures = new CompletableFuture[50];
        List<CompletableFuture<Void>> list  = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int num = i;
            list.add(CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(num * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("第" + num + "个线程执行了！");
            }, executorSece));
        }

        list.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

//        CompletableFuture.allOf(futures).thenRun(()->
        log.info("所有操作执行完毕");
//        );
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(futures);

    }


}
