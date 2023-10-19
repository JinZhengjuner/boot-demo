package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@ConfigurationProperties(
        prefix = "mafka.consumer"
)
@Configuration
public class MafkaConsumerProperties {
    private String namespace;
    private String appkey;
    private String topic;
    private String group;
    private String listener;
    private String className;
    private String consumerType;
    private boolean openHook = true;
    private boolean priority = false;
    private Map<String, String> otherProperties;
}
