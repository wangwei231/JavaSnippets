package com.example;


public class ThreadLocalDemo{
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            threadLocal.set(10);
            System.out.println("Thread 1: " + threadLocal.get());
            threadLocal.remove(); // 移除线程局部变量的值
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            threadLocal.set(20);
            System.out.println("Thread 2: " + threadLocal.get());
            threadLocal.remove(); // 移除线程局部变量的值
        }, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
