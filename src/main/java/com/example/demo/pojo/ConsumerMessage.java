package com.example.demo.pojo;

import lombok.Data;

@Data
public class ConsumerMessage {
    private Long storeTimestamp;
    private int id = 1;
}
