package com.example.demo.thread.test2;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        MyExecutor executor = new MyExecutor(5);
        Stream.iterate(1, item -> item + 1).limit(10).forEach(item -> {
            executor.execute(() -> { try {
                System.out.println(Thread.currentThread().getName() + " execute this task");
                TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) {
                e.printStackTrace(); }
            }); }
        ); }
}
