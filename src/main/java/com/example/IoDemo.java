package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class IoDemo {

    public static void main(String[] args) {
        String content = "Hello, Java I/O!";

        try (FileWriter writer = new FileWriter("example.txt")) {
            writer.write(content);
            System.out.println("内容已写入文件");
        } catch (IOException e) {
            System.err.println("发生错误：" + e.getMessage());
        }

        String filePath = "example.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("发生错误：" + e.getMessage());
        }
    }
}

