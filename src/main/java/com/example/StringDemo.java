package com.example;

import java.util.Arrays;
import java.util.List;

public class StringDemo {
    public static void main(String[] args) {
        String str = Integer.toString(1234321);
        System.out.println(str); // 输出: 1234321


        // 创建 StringBuilder
        StringBuilder sb = new StringBuilder("Hello");
        StringBuffer sb2 = new StringBuffer("Hello");

        // 拼接字符串
        sb.append(" ").append("World").append(1).append(.1).append('a');
        System.out.println("拼接字符串：" + sb.toString()); // 输出: Hello World10.1a


        // 插入字符串
        sb.insert(6, "Java ");

        // 删除子字符串
        sb.delete(6, 10);

        // 替换子字符串
        sb.replace(6, 11, "Java");

        // 反转字符串
        sb.reverse();

        // 获取字符
        char c = sb.charAt(0);

        // 设置字符
        sb.setCharAt(0, 'h');

        // 获取长度
        int length = sb.length();

        // 清空内容
        sb.setLength(0);

        // 输出结果
        System.out.println("最终结果：" + sb.toString());
        System.out.println("字符：" + c);
        System.out.println("长度：" + length);


        List<String> list = Arrays.asList("a", "b", "c");
        String joined = String.join(",", list);
        System.out.println(joined); // 输出: a,b,c

        // 字符串分割
        String string = "a,b,c,dd,ef,g";
        String[] parts = string.split(",");
        System.out.println(Arrays.toString(parts)); // 输出: [a, b, c]

    }
}
