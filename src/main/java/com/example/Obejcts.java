package com.example;

public class Obejcts {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o instanceof Object);
        System.out.println(o.hashCode());
        Object o2 = new Object();
        System.out.println(o2.hashCode());

        Class<?> aClass = o2.getClass();
        System.out.println(aClass);

        Integer i = Integer.valueOf(100);
        System.out.println(i.hashCode());
        System.out.println(i.equals(100));

        Integer i2 = Integer.valueOf(100);
        System.out.println(i2.equals(i));
        System.out.println(i2.hashCode());

        Character c = 'a';
        System.out.println(c.hashCode());
    }
}
