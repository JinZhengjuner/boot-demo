package com.example.demo.thread.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Student extends Thread{
    private String age;
    private Punishment punishment;

    @Override
    public void run() {
        copyWord();
    }

    public void copyWord(){
        int count = 0;
        String threadName = Thread.currentThread().getName();

        while (true){
            if (punishment.getLeftCopyCount() > 0) {
                int leftCopyCount = punishment.getLeftCopyCount();
                leftCopyCount--;
//                if(leftCopyCount<punishment.getLeftCopyCount()){
                    punishment.setLeftCopyCount(leftCopyCount);
//                }
                System.out.println(threadName+"线程-"+age + "抄写" + punishment.getWordToCopy() + "。还要抄写" + leftCopyCount + "次");
                count++;
            } else {
                break;
            }
        }
        System.out.println(threadName+"线程-"+age + "一共抄写了" + count + "次！");
    }

    public static void main(String[] args) {
        Punishment punishment = new Punishment(10000,"internationalization");

        Student xiaoming = new Student("小明",punishment);
        xiaoming.start();

        Student xiaozhang = new Student("小张",punishment);
        xiaozhang.start();

        Student xiaozhao = new Student("小赵",punishment);
        xiaozhao.start();
    }

}
