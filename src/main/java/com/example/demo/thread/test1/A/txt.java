package com.example.demo.thread.test1.A;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class txt {

    @SneakyThrows
    public static void main(String[] args) {


    }

    @SneakyThrows
    public synchronized void test() {
        wait();
        System.out.println("停止了");
    }
}
