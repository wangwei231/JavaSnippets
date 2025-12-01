package com.example;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * LocalDateTime 常见用法大全（一行一示例）
 * 运行方式：javac LocalDateTimeDemo.java && java LocalDateTimeDemo
 */
public class LocalDateTimeDemo {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        /* 1. 创建当前时间 */
        LocalDateTime now = LocalDateTime.now();
        System.out.println("1. 当前时间: " + now);

        /* 2. 手动指定时间 */
        LocalDateTime fixed = LocalDateTime.of(2025, 12, 31, 23, 59, 59);
        System.out.println("2. 固定时间: " + fixed);

        /* 3. 字符串 → LocalDateTime */
        LocalDateTime parse = LocalDateTime.parse("2025-12-31 23:59:59", FMT);
        System.out.println("3. 字符串解析: " + parse);

        /* 4. LocalDateTime → 字符串 */
        String str = fixed.format(FMT);
        System.out.println("4. 格式化为字符串: " + str);

        /* 5. 加减日期 */
        LocalDateTime plus = now.plusDays(1).minusHours(2);
        System.out.println("5. 加1天减2小时: " + plus);

        /* 6. 相差多少天/小时/分钟 */
        long days = ChronoUnit.DAYS.between(now, plus);
        long hours = ChronoUnit.HOURS.between(now, plus);
        System.out.println("6. 相差天数: " + days + ", 小时: " + hours);

        /* 7. 获取毫秒/秒时间戳（依赖时区） */
        long epochMilli = now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long epochSec = now.atZone(ZoneId.systemDefault()).toEpochSecond();
        System.out.println("7. 毫秒戳: " + epochMilli + ", 秒戳: " + epochSec);

        /* 8. 时间戳 → LocalDateTime */
        LocalDateTime fromMilli = Instant.ofEpochMilli(epochMilli)
                                         .atZone(ZoneId.systemDefault())
                                         .toLocalDateTime();
        System.out.println("8. 毫秒戳转回: " + fromMilli);

        /* 9. 时区转换：上海 → 东京 */
        ZonedDateTime tokyo = now.atZone(ZoneId.of("Asia/Shanghai"))
                                 .withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("9. 东京时间: " + tokyo);

        /* 10. 与 Date 互转 */
        Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime fromDate = date.toInstant()
                                     .atZone(ZoneId.systemDefault())
                                     .toLocalDateTime();
        System.out.println("10. Date → LocalDateTime: " + fromDate);

        /* 11. 取当天开始/结束 */
        LocalDateTime startOfDay = now.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = now.toLocalDate().atTime(LocalTime.MAX);
        System.out.println("11. 当天开始: " + startOfDay + " 结束: " + endOfDay);

        /* 12. 比较大小 */
        boolean isBefore = now.isBefore(fixed);
        boolean isAfter = now.isAfter(fixed);
        System.out.println("12. 是否早于固定时间: " + isBefore + " 晚于: " + isAfter);

        /* 13. 截断到分钟（去掉秒/纳秒） */
        LocalDateTime truncated = now.truncatedTo(ChronoUnit.MINUTES);
        System.out.println("13. 截断到分钟: " + truncated);

        /* 14. 线程安全常量用法 */
        LocalDateTime constant = LocalDateTime.of(2000, 1, 1, 0, 0);
        System.out.println("14. 常量时间: " + constant);

        /* 15. 数据库风格 (yyyy-MM-dd HH:mm:ss) 快速格式化 */
        String dbStyle = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("15. DB 风格字符串: " + dbStyle);
    }
}
