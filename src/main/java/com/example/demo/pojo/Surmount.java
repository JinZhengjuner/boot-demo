package com.example.demo.pojo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Surmount implements Runnable{

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    @Override
    public void run() {

        try {
            for(int i = 1; i < 4; i++){
                Random rand = new Random();
                int randomNum = rand.nextInt((3000 - 1000) + 1) + 1000;//产生1000到3000之间的随机整数
                Thread.sleep(randomNum);
                String name = Thread.currentThread().getName();
                System.out.println(name+"翻过了第" + i +"个障碍");
                cyclicBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++){
            Thread thread = new Thread(new Surmount(),"选手"+ i );
            thread.start();
        }
        System.out.println("main is end");
    }
}
