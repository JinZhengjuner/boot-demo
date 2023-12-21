package com.example.demo.zerenlian;

public class Master extends Approver{


    public Master(String name) {
        super(name);
    }

    @Override
    public void approve(LeaveRequest request) {
        if (request.getDays() > 7) {
            System.out.println("校长" + name + "审批了" + request.getName() + "的请假申请，天数为" + request.getDays());
        } else {
            if (next != null) {
                next.approve(request);
            }
        }
    }
}
