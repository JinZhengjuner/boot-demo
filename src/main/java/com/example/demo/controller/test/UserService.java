package com.example.demo.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {


    @GetMapping("/user/login")
    public void login(String username, String password) {
        // 验证用户名和密码
        User user = new User(username, password);

        // 将用户信息存入 ThreadLocal
        UserContext.setUser(user);
    }

    @GetMapping("/user/test")
    public void updateUserProfile(String email, String phone) {
        // 获取当前用户信息
        User user = UserContext.getUser();
        System.out.println(user);


    }
}
