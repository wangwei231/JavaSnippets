package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;



public class ArrayListExample {
    public static void main(String[] args) {
        // 创建一个 ArrayList
        List<String> fruits = new ArrayList<>();
        System.out.println(fruits instanceof ArrayList);
        if (fruits instanceof ArrayList a ) {
            System.out.println(a);
        }
        Object aaa = null;
        try {
            aaa.toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        int[] a = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        int[] b = Arrays.copyOf(a, 10);
        int[] c = Arrays.copyOfRange(a, 0, 2);
        System.out.println(b);
        System.out.println("b.length"+b.length);

        Integer[] srcArray = {1, 2, 3, 4, 5};

        // 目标数组
        Integer[] destArray = new Integer[5];

        // 使用 System.arraycopy 复制数组
        System.arraycopy(srcArray, 0, destArray, 0, srcArray.length);

        // 修改目标数组中的一个元素
        destArray[0] = 100;

        // 输出结果
        System.out.println("Source Array: " + Arrays.toString(srcArray));
        System.out.println("Destination Array: " + Arrays.toString(destArray));
        
        // 添加元素
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("After adding elements: " + fruits);

        fruits.stream().forEach(fruit -> System.out.println(fruit));
        fruits.forEach(fruit -> System.out.println(fruit));

        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        // 在指定位置添加元素
        fruits.add(1, "Date");
        System.out.println("After adding 'Date' at index 1: " + fruits);

        // 获取元素
        String firstFruit = fruits.get(0);
        System.out.println("First fruit: " + firstFruit);

        // 设置元素
        fruits.set(0, "Apricot");
        System.out.println("After setting 'Apricot' at index 0: " + fruits);

        // 删除元素
        fruits.remove(0); // 删除索引为 0 的元素
        System.out.println("After removing element at index 0: " + fruits);

        // 删除特定元素
        fruits.remove("Banana");
        System.out.println("After removing 'Banana': " + fruits);

        // 检查是否包含某个元素
        boolean containsCherry = fruits.contains("Cherry");
        System.out.println("Contains 'Cherry': " + containsCherry);

        // 获取列表大小
        int size = fruits.size();
        System.out.println("Size of the list: " + size);

        // 遍历列表
        System.out.println("Iterating through the list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 清空列表
        fruits.clear();
        System.out.println("After clearing the list: " + fruits);
    }
}
