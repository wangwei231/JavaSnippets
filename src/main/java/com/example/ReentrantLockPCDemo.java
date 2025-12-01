package com.example;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.LinkedList;
import java.util.Queue;

public class ReentrantLockPCDemo {

    // 共享队列，最大容量为 5
    private static final int CAPACITY = 5;
    private final Queue<Integer> queue = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull  = lock.newCondition(); // 队列未满
    private final Condition notEmpty = lock.newCondition(); // 队列非空

    // 生产者
    public void produce(int value) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == CAPACITY) {
                notFull.await(); // 队列满，等待
            }
            queue.offer(value);
            System.out.println("Produced: " + value + " | Queue: " + queue);
            notEmpty.signal(); // 通知消费者
        } finally {
            lock.unlock();
        }
    }

    // 消费者
    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await(); // 队列空，等待
            }
            int value = queue.poll();
            System.out.println("Consumed: " + value + " | Queue: " + queue);
            notFull.signal(); // 通知生产者
        } finally {
            lock.unlock();
        }
    }

    // 主函数：启动 2 个生产者 + 2 个消费者
    public static void main(String[] args) {
        ReentrantLockPCDemo demo = new ReentrantLockPCDemo();

        // 生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        demo.produce(j);
                        Thread.sleep(300); // 模拟耗时
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Producer-" + i).start();
        }

        // 消费者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        demo.consume();
                        Thread.sleep(500); // 模拟耗时
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Consumer-" + i).start();
        }
    }
}

