package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        List<String> upperCaseFruits = fruits.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upperCaseFruits);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        // 统计字符串长度大于 5 的元素数量
        long count = fruits.stream()
                .filter(f -> f.length() > 5)
                .count();
        System.out.println(count);

        // 查找第一个字符串长度大于 5 的元素
        String firstLongFruit = fruits.stream()
                .filter(f -> f.length() > 7)
                .findFirst()
                .orElse(null);
        System.out.println(firstLongFruit);

        // 对字符串列表进行排序
        List<String> sortedFruits = fruits.stream()
                .sorted()
                .toList();
        System.out.println(sortedFruits);

        // 对整数列表进行排序
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        System.out.println(sortedNumbers);

        // 对字符串列表进行分组
        Map<Integer, List<String>> groupedFruits = fruits.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupedFruits);

        // 对整数列表进行分组
        Map<Integer, List<Integer>> groupedNumbers = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 3));
        System.out.println(groupedNumbers);

        // 并行流
        long parallelSum = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(parallelSum);

        List<Double> floatNumbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        double average = floatNumbers.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
        System.out.println(average);
        
    }
}
