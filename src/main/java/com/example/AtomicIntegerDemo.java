package com.example;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    // 1. 定义原子计数器
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final int THREADS = 10;
        final int INCREMENTS_PER_THREAD = 1_000;
        CountDownLatch latch = new CountDownLatch(THREADS);

        for (int i = 0; i < THREADS; i++) {
            new Thread(() -> {
                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
                    counter.incrementAndGet(); // 原子自增
                }
                latch.countDown();
            }).start();
        }

        latch.await(); // 等待所有线程完成
        System.out.println("Final counter = " + counter.get()); // 必定输出 10 000
    }
}

