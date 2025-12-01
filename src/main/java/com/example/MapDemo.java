package com.example;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

public class MapDemo {
    public static void main(String[] args) {
        // 创建一个HashMap对象
        Map<String, Integer> map = new HashMap<>();

        // 添加键值对
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        // 获取键对应的值
        System.out.println("Alice's age: " + map.get("Alice"));
        System.out.println("Dave's age: " + map.getOrDefault("Dave", 40));

        // 检查是否包含某个键
        System.out.println("Does map contain key 'Bob'? " + map.containsKey("Bob"));

        // 检查是否包含某个值
        System.out.println("Does map contain value 30? " + map.containsValue(30));

        // 获取哈希表的大小
        System.out.println("Size of map: " + map.size());

        // 检查哈希表是否为空
        System.out.println("Is map empty? " + map.isEmpty());

        // 遍历哈希表的键
        System.out.println("Keys in map: " + map.keySet());

        // 遍历哈希表的值
        System.out.println("Values in map: " + map.values());

        // 遍历哈希表的键值对
        System.out.println("Entries in map: " + map.entrySet());

        // 使用forEach遍历哈希表
        System.out.println("Iterating over map using forEach:");
        map.forEach((key, value) -> System.out.println(key + ": " + value));


        // 1. 使用keySet()迭代
        System.out.println("迭代方式1: 使用keySet()");
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // 2. 使用values()迭代
        System.out.println("\n迭代方式2: 使用values()");
        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }

        // 3. 使用entrySet()迭代
        System.out.println("\n迭代方式3: 使用entrySet()");
        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 4. 使用entrySet()和迭代器迭代
        Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, Integer> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 5. 使用forEach方法迭代
        System.out.println("\n迭代方式5: 使用forEach方法");
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        // 6. 使用Java 8的Stream API迭代
        System.out.println("\n迭代方式6: 使用Java 8的Stream API");
        map.entrySet().stream().forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));


        map.forEach((key, val)->{
            System.out.println("Key: " + key + ", Value: " + val);
        });

        // 删除键值对
        map.remove("Bob");
        System.out.println("Map after removing 'Bob': " + map);

        // 清空哈希表
        map.clear();
        System.out.println("Map after clearing: " + map);
    }
}
