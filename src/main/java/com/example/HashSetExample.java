package com.example;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        // 创建一个 HashSet
        Set<String> set = new HashSet<>();

        // 添加元素
        boolean a = set.add("Apple");
        boolean b = set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        // 检查是否包含某个元素
        System.out.println("Contains 'Banana': " + set.contains("Banana")); // true

        // 移除元素
        set.remove("Banana");

        // 检查是否包含某个元素
        System.out.println("Contains 'Banana': " + set.contains("Banana")); // false

        // 遍历集合
        System.out.println("Elements in set:");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 获取集合大小
        System.out.println("Size of set: " + set.size()); // 2

        // 清空集合
        set.clear();

        // 检查集合是否为空
        System.out.println("Is set empty: " + set.isEmpty()); // true
    }
}
