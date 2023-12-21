package com.example.demo.zerenlian;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LeaveRequest {
    //请假人姓名
    private String name;
    //请假天数
    private Integer days;
}
