package com.example.demo.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockCheck {

    @ExcelProperty("ent_id")
    private Long entId;

    @ExcelProperty("item_code")
    private String itemCode;

    @ExcelProperty("barcode")
    private String barcode;

    @ExcelProperty("oldAvailableQty")
    private Double oldAvailableQty;

    @ExcelProperty("skuAvailableQty")
    private Double skuAvailableQty;

    @ExcelProperty("tenantId")
    public Long tenantId;

    @ExcelProperty("warehouseId")
    public Long warehouseId;

    @ExcelProperty("sku")
    private String sku;
}
