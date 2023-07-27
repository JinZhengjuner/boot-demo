package com.example.demo.zongjie.lingpaitong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LimitConfig {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Bean
    public LimitConfig init(){
        return new LimitConfig();
    }


    /**
     * 获取lua脚本
     * @return
     */
    private  DefaultRedisScript getRedisScript(){
        DefaultRedisScript redisScript = new DefaultRedisScript<List>();
        redisScript.setResultType(Long.class);
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("permit.lua")));
        return redisScript;
    }

    public long canSend (String key){
        List<String> keyList = new ArrayList<>(1);
        keyList.add(key);
        //1最大限制容量 2：每次添加令牌数 3：令牌添加间隔(秒) 4：当前时间
        String[] str = {"20", "5", "10", String.valueOf(System.currentTimeMillis()/1000)};
        return (long) redisTemplate.execute(getRedisScript(), keyList, str);
    }
}
