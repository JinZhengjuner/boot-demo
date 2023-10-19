package com.example.demo.arthas.other;

import com.example.demo.pojo.A;

import java.util.Optional;
import java.util.Random;

public class MathGame {
    private static Random random = new Random();

    public static void main(String[] args) {
        A a = null;
        A aa = Optional.ofNullable(a).orElse(new A());

    }

    public void run(){
        try {
            int number = random.nextInt();

        }catch (Exception e){
            System.out.println(e);
        }
    }


}
