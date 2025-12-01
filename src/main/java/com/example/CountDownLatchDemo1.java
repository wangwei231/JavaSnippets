package com.example;


import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo1 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);

        Runnable thread1 = () -> {
            System.out.println("Thread 1 is running");
            latch.countDown();
        };
        new Thread(thread1).start();

        Runnable thread2 = () -> {
            System.out.println("Thread 2 is running");
            latch.countDown();
        };
        new Thread(thread2).start();

        try {
            latch.await();
            System.out.println("All threads have finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
