package com.example.demo.zerenlian;

public abstract class Approver {
    String name;
    Approver next;

    public Approver(String name){
        this.name = name;
    }

    //设置下一个审批者
    public void setNext(Approver next){
        this.next = next;
    }

    //审批请求
    public abstract void approve(LeaveRequest request);

}
