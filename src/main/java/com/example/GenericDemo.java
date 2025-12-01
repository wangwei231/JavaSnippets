package com.example;

public class GenericDemo<T> {
    private T t;
    
    public T getT() {
        return t;
    }
    
    public void setT(T t) {
        this.t = t;
    }

    public void printT() {
        System.out.println(t.hashCode());
        System.out.println(t);
    }

    public static void main(String[] args) {
        GenericDemo<Integer> genericDemo = new GenericDemo<>();
        genericDemo.setT(100);
        genericDemo.printT();
        System.out.println(genericDemo.getT());
    }
}
