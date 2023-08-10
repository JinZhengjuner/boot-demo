package com.example.demo.config;

import com.example.demo.pojo.StockCheck;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig  {


    @Bean(value = "itemConsumerBean", initMethod = "start")
    public ItemConsumerBean s(@Qualifier("stockCheck") StockCheck stockCheck){
        return new ItemConsumerBean();
    }

}
