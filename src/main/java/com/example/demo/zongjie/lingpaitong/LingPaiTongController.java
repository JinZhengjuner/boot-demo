package com.example.demo.zongjie.lingpaitong;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/zongjie/")
@RestController
@Slf4j
public class LingPaiTongController {

    @Autowired
    private LimitConfig limitConfig;

   @GetMapping("/lingpaitong")
   public String getToken(String key){

       for (int i = 0; i < 10; i++) {
           long l = limitConfig.canSend(key);
           log.info("{}, {}", key, l);
       }
      return "success";
   }

}
