package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.Duration;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TimeDemoTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testMainMethodOutputFormat() {
        // 测试main方法的输出格式是否正确
        TimeDemo.main(new String[]{});
        
        String output = outputStream.toString();
        String[] lines = output.trim().split("\n");
        
        assertEquals(2, lines.length, "应该有两行输出");
        assertTrue(lines[0].startsWith("当前时间戳: "), "第一行应该以'当前时间戳: '开头");
        assertTrue(lines[1].startsWith("未来10分钟的时间戳: "), "第二行应该以'未来10分钟的时间戳: '开头");
    }

    @Test
    public void testTimeCalculationAccuracy() {
        // 测试时间计算的准确性
        Instant now = Instant.now();
        Instant future = now.plus(Duration.ofMinutes(10));
        
        long startTime = now.toEpochMilli();
        long endTime = future.toEpochMilli();
        
        long timeDifference = endTime - startTime;
        long expectedDifference = 10 * 60 * 1000; // 10分钟 = 600000毫秒
        
        // 允许100毫秒的误差范围
        assertEquals(expectedDifference, timeDifference, 100, "时间差应该接近10分钟");
    }

    @Test
    public void testTimestampValidity() {
        // 测试生成的时间戳是否有效
        Instant now = Instant.now();
        Instant future = now.plus(Duration.ofMinutes(10));
        
        long startTime = now.toEpochMilli();
        long endTime = future.toEpochMilli();
        
        assertTrue(startTime > 0, "当前时间戳应该是正数");
        assertTrue(endTime > 0, "未来时间戳应该是正数");
        assertTrue(endTime > startTime, "未来时间戳应该大于当前时间戳");
    }

    @Test
    public void testDurationCalculation() {
        // 测试Duration计算的正确性
        Duration duration = Duration.ofMinutes(10);
        
        assertEquals(10, duration.toMinutes(), "Duration应该表示10分钟");
        assertEquals(600, duration.getSeconds(), "Duration应该表示600秒");
        assertEquals(600000, duration.toMillis(), "Duration应该表示600000毫秒");
    }
}