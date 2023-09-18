package com.example.demo.arthas.other;

import java.util.Random;

public class MathGame {
    private static Random random = new Random();

    public static void main(String[] args) {


    }

    public void run(){
        try {
            int number = random.nextInt();

        }catch (Exception e){
            System.out.println(e);
        }
    }


}
