package com.example.demo.zerenlian;

public class ClassAdviser extends Approver{
    public ClassAdviser(String name) {
        super(name);
    }

    @Override
    public void approve(LeaveRequest request) {
        if (request.getDays() <= 2) {
            System.out.println("班主任" + name + "审批" + request.getName() + "的请假申请，天数为" + request.getDays());
        } else {
            if (next != null) {
                System.out.println("班主任审批不了，交由下一级");
                next.approve(request);
            }
        }
    }

    public static void main(String[] args) {
        Approver classAdviser = new ClassAdviser("张班主任");
        Approver gradeLeader = new GradeLeader("李年级组长");
        Approver schoolMaster = new Master("王校长");
        classAdviser.setNext(gradeLeader);
        gradeLeader.setNext(schoolMaster);

        LeaveRequest request = new LeaveRequest("小刚", 20);
        classAdviser.approve(request);
    }
}
