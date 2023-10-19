package com.example.demo.arthas.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class RedisTest01 {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/redis/for")
    public String redisFor(){
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            redisTemplate.opsForValue().set("for" + i, String.valueOf(i));
        }
        Long time = System.currentTimeMillis()-start;
        log.info("for插入100个耗时,{}", time);
        return String.valueOf(time);
    }

    @GetMapping("/redis/pip")
    public String redisPip(){
        Long start = System.currentTimeMillis();
        List<Object> result = redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            connection.set("key1".getBytes(), "value1".getBytes());
            connection.get("key1".getBytes());
            connection.set("key2".getBytes(), "value2".getBytes());
            connection.get("key2".getBytes());
            return null;
        });
        Long time = System.currentTimeMillis()-start;
        log.info("pip,{}", result);
        return String.valueOf(time);
    }




}
