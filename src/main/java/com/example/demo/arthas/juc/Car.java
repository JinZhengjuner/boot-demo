package com.example.demo.arthas.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class Car {
    private String name;

    private Tank tank;

    public Car() {
        System.out.println("car的构造调用了...");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Car car = (Car) context.getBean("car");
        Car car2 = (Car) context.getBean("car");

        System.out.println( car2==car);
        System.out.println( car2.getTank()==car.getTank());
    }
}
