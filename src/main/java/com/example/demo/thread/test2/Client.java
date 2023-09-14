package com.example.demo.thread.test2;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class Client {
    public static void main(String[] args) {
        System.out.println(isValidStock("2.32"));

    }

    private static boolean isValidStock(String stock) {
        if (StringUtils.isBlank(stock)){
            return false;
        }
        try {
            int value = Integer.parseInt(stock);
            if (value >= 0 && value <= 99999) {
                return isValidDouble(stock);
            }
        } catch (NumberFormatException e) {
            log.info("批量修改库存，stock校验失败");
        }
        return false;
    }

    private static boolean isValidDouble(String qty) {
        try {
            Double.valueOf(qty);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
