package com.example.demo.thread.test2;

import java.util.LinkedList;

public class RunnableTaskQueue {
    private final LinkedList<Runnable> tasks = new LinkedList<>();

    public Runnable getTask() throws InterruptedException {
        synchronized (tasks){
            while (tasks.isEmpty()){
                System.out.println(Thread.currentThread().getName() + "says task queue is empty. i will wait");
                tasks.wait();
            }
            return tasks.removeFirst();
        }
    }

    public void addTask(Runnable runnable){
        synchronized (tasks){
            tasks.add(runnable);
            tasks.notifyAll();
        }
    }
}
