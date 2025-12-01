package com.example;

public class IncreDemo {
    private int count = 0;

    public void increment() {
        count++;
    }

    public static void main(String[] args) {
        IncreDemo demo = new IncreDemo();
        demo.increment();
    }
}
