package com.example.demo.controller.test;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("log/test")
@RestController
public class TestLog {

    @GetMapping("a")
    public String A() throws InterruptedException {
        Thread.sleep(1000);
        return "A";
    }

    @PutMapping("put")
    public String put(@RequestBody Map<String, String> map) throws InterruptedException {
        Thread.sleep(100);
        return "put" + map.toString();
    }
}
