package com.example;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Comparator;



public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put(1, "a");
        linkedHashMap.put(2, "b");
        linkedHashMap.put(3, "c");
        System.out.println(linkedHashMap); // 输出: {1=a, 2=b, 3=c}

        linkedHashMap.get(1);
        System.out.println(linkedHashMap); // 输出: {2=b, 3=c, 1=a}
        
        Set<Map.Entry<Integer, String>> entrySet = linkedHashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }
        System.out.println(entrySet); // 输出: [2=b, 3=c, 1=a]


        TreeMap<Integer, String> desc = new TreeMap<>(Comparator.reverseOrder());
        desc.put(3, "C");
        desc.put(1, "A");
        desc.put(2, "B");

        System.out.println(desc); // {3=C, 2=B, 1=A}

    }
}
