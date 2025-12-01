package com.example;

public class ByteDemo {
    public static void main(String[] args) {
        char c = '世';

        // 将char转换为字节数组
        byte[] charBytes = new byte[2];
        charBytes[0] = (byte) (c >> 8);  // 高字节
        charBytes[1] = (byte) (c & 0xFF); // 低字节

        // 打印字节数组长度
        System.out.println("字节数组长度：" + charBytes.length);

        // 打印每个字节的内容
        for (byte b : charBytes) {
            System.out.print(String.format("%02X ", b));
        }
        System.out.println();

        String str1 = "世";

        // 使用UTF-16编码将字符串转换为字节数组
        byte[] bytes = str1.getBytes();
        System.out.println("字节数组长度：" + bytes.length);
        for (byte b : bytes) {
            System.out.print(String.format("%02X ", b));
        }

        
    }
}
