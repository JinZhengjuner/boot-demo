package com.example.demo.arthas.juc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.demo.arthas.juc"})
public class MainConfig {

    @Bean("car")
    public Car car(){
        Car car = new Car();
        car.setName("jzj");
//        car.setTank(tank());
        return car;
    }

    @Bean
    private Tank tank() {
        return new Tank();
    }
}
