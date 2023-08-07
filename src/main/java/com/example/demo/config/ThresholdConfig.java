package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "mtwm-api-threshold")
@Component
public class ThresholdConfig {

    private String appIdToThresholdStr = "{}";

}
