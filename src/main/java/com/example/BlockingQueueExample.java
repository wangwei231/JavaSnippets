package com.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个固定大小的阻塞队列
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        // 创建生产者线程，向队列中添加元素
        Runnable producer = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    queue.put(i); // 将元素添加到队列中
                    System.out.println("Produced " + i);
                    Thread.sleep(50); // 模拟生产耗时
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // 创建消费者线程，从队列中移除元素
        Runnable consumer = () -> {
            try {
                while (true) {
                    int value = queue.take(); // 从队列中取出元素
                    System.out.println("Consumed " + value);
                    Thread.sleep(100); // 模拟消费耗时
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread() {
            @Override
            public void run() {
                consumer.run();
            }
        }.start();

        // 创建并启动生产者和消费者线程
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        // 等待线程结束
        producerThread.join();
        consumerThread.join();
    }
}
