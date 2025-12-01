package com.example;

public class ThreadDemo {
    public static void main(String[] args) {
        // 创建线程
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
        });

        // 启动线程
        thread.start();

        // 等待线程执行完毕
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread has finished");
    }
}
