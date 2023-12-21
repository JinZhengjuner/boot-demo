package com.example.demo.zerenlian;

public class GradeLeader extends Approver{
    public GradeLeader(String name) {
        super(name);
    }

    @Override
    public void approve(LeaveRequest request) {
        if (request.getDays() <= 7){
            System.out.println("年级组长" + name + "审批" + request.getName() + "的请假申请，天数为" + request.getDays());
        }else {
            if (next != null){
                System.out.println("年级组长审批不了，交由下一级");
                next.approve(request);
            }
        }
    }
}
