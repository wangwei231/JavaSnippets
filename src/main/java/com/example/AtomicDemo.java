
package com.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicDemo {
    // 内部类
    private static class CASCounter {
        private final AtomicInteger count = new AtomicInteger(0);

        public void increment() {
            int current;
            int newValue;
            do {
                current = count.get(); // 获取当前值作为预期值
                newValue = current + 1; // 新值是当前值加1
            } while (!count.compareAndSet(current, newValue)); // CAS操作
        }

        public int getCount() {
            return count.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CASCounter counter = new CASCounter(); // 创建CASCounter实例

        // 创建10个线程，每个线程对计数器加1000次
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment(); // 调用CASCounter的increment方法
                }
            });
            threads[i].start();
        }

        // 等待所有线程完成
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("最终计数：" + counter.getCount()); // 应该是10000
    }
}
