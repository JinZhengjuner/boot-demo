package com.example.demo.arthas.juc;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Juc01 implements Callable {
    private static int i = 1;

    @Override
    public Integer call() throws Exception {
        for (int j = 0; j < 100; j++) {
            System.out.println(Thread.currentThread().getName());
            i++;
        }
        return i;
    }


    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(new Juc01());
        new Thread(futureTask).start();
        Thread.sleep(1000);
        System.out.println("----" + futureTask.get());



    }

    private static void m1() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        for (ThreadInfo threadInfo : threadMXBean.dumpAllThreads(false, false)) {
            System.out.println(threadInfo.getThreadId() + threadInfo.getThreadName());
        }
        //进程中的通信：

        System.out.println("核心数：" + Runtime.getRuntime().availableProcessors());
    }


}
