package com.example.demo.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserService {


    @PostMapping("/user/login")
    public void login(String username, String password, @RequestParam("fileName")MultipartFile multipartFile, B b) {
        String name = multipartFile.getName();
        System.out.println();

    }

    @GetMapping("/user/test")
    public void updateUserProfile(String email, String phone) {
        // 获取当前用户信息
        User user = UserContext.getUser();
        System.out.println(user);


    }
}
