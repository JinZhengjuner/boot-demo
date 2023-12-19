package com.example.demo.controller.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockBizType {

    /**
     * 库存流水业务类型id
     */
    private Integer bizId;

    /**
     * 库存流水业务类型描述
     */
    private String desc;

}
