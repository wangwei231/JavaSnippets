package com.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentCollectionExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 提交任务到线程池
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                // 并发地向map中添加键值对
                map.put(Thread.currentThread().getName(), (int) (Math.random() * 100));
                // 并发地从map中获取值
                int value = map.get(Thread.currentThread().getName());
                System.out.println("Thread: " + Thread.currentThread().getName() + ", Value: " + value);
            });
        }

        // 关闭线程池
        executorService.shutdown();
        executorService.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);

        // 打印结果
        System.out.println("Map size: " + map.size());
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
}
