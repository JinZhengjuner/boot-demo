package com.example.demo.zongjie.lingpaitong;

import com.example.demo.config.MafkaConsumerProperties;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("limit")
public class GuavaRateLimit {
    private static Long barcode = 6978765856004L;
    private static Integer itemcode = 1873204;
    private static Integer num = 4;

    @Autowired
    private MafkaConsumerProperties mafkaConsumerProperties;

    @GetMapping("get")
    public StockDTO getNum(){
        StockDTO stockDTO = new StockDTO();
        stockDTO.setCode(String.valueOf(itemcode++));
        stockDTO.setBarcode(String.valueOf(barcode++));
        stockDTO.setBrandName("测试品牌"+ num);
        stockDTO.setName("测试商品"+ num++);
        return stockDTO;
    }

    @GetMapping("/test/result")
    public void b(@Param("num") String num){
        log.info("获取到变量中的结果, {}", num);
    }
}
