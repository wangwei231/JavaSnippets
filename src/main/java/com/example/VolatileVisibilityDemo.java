package com.example;

public class VolatileVisibilityDemo {

    // 1. 第一次：不加 volatile
    // 2. 第二次：加上 volatile
    //private static volatile boolean stop = false;
    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {

        // 工作线程：死循环直到 stop 变成 true
        Thread worker = new Thread(() -> {
            System.out.println("worker 开始运行...");
            while (!stop) {
                // 空转，不做任何 IO，减少 JIT 优化差异
            }
            System.out.println("worker 看到了 stop = true，结束循环！");
        }, "worker");

        worker.start();

        // 主线程：睡 1 秒后将 stop 设为 true
        Thread.sleep(1000);
        System.out.println("main 把 stop 置为 true");
        stop = true;

        // 等待工作线程结束
        worker.join();
        System.out.println("程序结束");
    }
}
