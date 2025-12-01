package com.example;

import java.time.Instant;
import java.time.Duration;

public class TimeDemo {

    public static void main(String[] args) {
        // 获取当前时间的 Instant 对象
        Instant now = Instant.now();

        // 计算未来 10 分钟的时间
        Instant future = now.plus(Duration.ofMinutes(10));

        // 转换为毫秒时间戳
        long startTime = now.toEpochMilli();
        long endTime = future.toEpochMilli();

        // 打印时间戳范围
        System.out.println("当前时间戳: " + startTime);
        System.out.println("未来10分钟的时间戳: " + endTime);
    }
}
