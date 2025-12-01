package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CreateThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 方式1：通过继承Thread类
        int a = 10;
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println("a = " + a);
                System.out.println("Thread 1: Running");
            }
        };
        thread1.start();

        // 方式2：通过实现Runnable接口

        Runnable runnable = () -> System.out.println("Thread 2: Running");
        Thread thread2 = new Thread(runnable);
        thread2.start();

        // 方式3：通过实现Callable接口
        Callable<String> callable = () -> "Thread 3: Running";
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread3 = new Thread(futureTask);
        thread3.start();
        System.out.println(futureTask.get());

        // 方式4：通过ExecutorService线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> System.out.println("Thread 4: Running"));
        executorService.submit(() -> System.out.println("Thread 5: Running"));
        
        executorService.shutdown();
    }
}
