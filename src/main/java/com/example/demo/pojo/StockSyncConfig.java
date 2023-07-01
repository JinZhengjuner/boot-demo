package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockSyncConfig {

    private List<Long> entids;

    private String regionCode;

    private String paramId;

    private Integer pageSize;

    private String startTime;

    private String endTime;

    /**
     * 标识腾讯云(tx)还是阿里云(ali)
     */
    private String connectType;
}

