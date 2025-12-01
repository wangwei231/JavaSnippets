package com.example;

public class ConvertDemo {
    public static void main(String[] args) {
        long l = 1234321L;
        System.out.println(l); // 输出: 1234321

        Long a = 10L;
        System.out.println(String.valueOf(a)); // 输出: 10

        String str = String.valueOf(l);
        System.out.println(str); // 输出: 1234321
        
        // 转换为字符串
        str = Long.toString(l);
        System.out.println(str); // 输出: 1234321

        // 转换为整数
        int i = Integer.parseInt(str);
        System.out.println(i); // 输出: 1234321

        // 转换为浮点数
        float f = Float.parseFloat(str);
        System.out.println(f); // 输出: 1234321.0
    }
}
