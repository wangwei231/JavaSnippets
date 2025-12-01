package com.example;

public class HandleException {
    public static void main(String[] args) {
        try {
            throw new ExceptionDemo("这是一个异常");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
