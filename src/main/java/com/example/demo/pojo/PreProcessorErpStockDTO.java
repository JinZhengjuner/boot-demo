package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Slf4j
public class PreProcessorErpStockDTO {

    @JsonProperty("tenantId")
    private Long tenantId;

    @JsonProperty("timestamp")
    private Long time;

    public static int i = 0;


    public static void main(String[] args) {
        try {
            redo();
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println("num"+i);
            //160 851
            //320 4127
        }

    }

    private static void redo() {
        i++;
        redo();
    }
}
