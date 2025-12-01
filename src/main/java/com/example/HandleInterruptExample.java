package com.example;


public class HandleInterruptExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                //while (true) {
                System.out.println("Thread is running");
                try {
                    Thread.sleep(1000); // 模拟长时间运行的任务
                } catch (InterruptedException e) {
                    System.out.println("Thread is interrupted");
                    e.printStackTrace();
                    System.out.println("Thread is "+Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt(); // 重新设置中断状态
                    System.out.println("Thread is "+Thread.currentThread().isInterrupted());
                }
            }
        });

        thread.start();
        try {
            Thread.sleep(3000); // 给线程一些时间来运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt(); // 请求中断线程
    }
}
