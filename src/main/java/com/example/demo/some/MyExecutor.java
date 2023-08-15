package com.example.demo.some;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutor   {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 1L, TimeUnit.MINUTES, new SynchronousQueue<>());
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            executor.submit(() -> {
                System.out.println(finalI);
            });
        }
        executor.shutdown();
    }
}
