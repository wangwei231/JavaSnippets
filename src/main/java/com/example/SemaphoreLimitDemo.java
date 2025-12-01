package com.example;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreLimitDemo {
    // 同时最多 3 个许可证
    private static final Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final int no = i;
            pool.submit(() -> {
                try {
                    semaphore.acquire();         // 获取许可证
                    System.out.println("线程 " + no + " 开始执行");
                    Thread.sleep(1000);          // 模拟耗时任务
                    System.out.println("线程 " + no + " 执行完毕");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();         // 归还许可证
                }
            });
        }
        pool.shutdown();
    }
}
