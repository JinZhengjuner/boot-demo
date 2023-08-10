package com.example.demo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

@Slf4j
public class ExcutorTest {


    @Test
    @SneakyThrows
    public void test1() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        log.info("start");
        executorService.schedule(()->{
            log.info("执行了");
        }, 5, TimeUnit.SECONDS);
        Thread.sleep(100000);
    }

    ExecutorService executor = Executors.newFixedThreadPool(2);
    SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();

    @Test
    public void test() throws InterruptedException {
        Runnable producer = () -> {
            Object object = new Object();
            try {
                log.info("start");
                Thread.sleep(2000);
                log.info("end");
                synchronousQueue.put(object);
                log.info("produced {}", object);
            } catch (InterruptedException ex) {
                log.error(ex.getMessage(), ex);
            }

        };

        Runnable consumer = () -> {
            try {
                log.info("get执行了");
                Object object = synchronousQueue.take();
                log.info("consumed {}", object);
            } catch (InterruptedException ex) {
                log.error(ex.getMessage(), ex);
            }
        };

        executor.submit(producer);
        executor.submit(consumer);

        executor.awaitTermination(500000, TimeUnit.MILLISECONDS);
        executor.shutdown();
    }


}