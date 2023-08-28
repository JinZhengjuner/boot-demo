package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "test")
public class User {
    private String id;
    private String name;
    private List<String> fruits;
    private Double qty;
}
