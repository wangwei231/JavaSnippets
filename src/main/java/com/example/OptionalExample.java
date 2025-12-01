package com.example;

import java.util.Optional;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class OptionalExample {
    public static void main(String[] args) {
        // 创建 Optional
        Optional<String> optionalName = Optional.ofNullable("Kimi");

        // 检查值是否存在
        if (optionalName.isPresent()) {
            System.out.println("Optional contains: " + optionalName.get());
        } else {
            System.out.println("Optional is empty");
        }

        // 提供默认值
        String name = optionalName.orElse("Guest");
        System.out.println("Name: " + name);

        // 使用 ifPresent 执行操作
        optionalName.ifPresent(n -> System.out.println("Hello, " + n));

        // 映射值
        Optional<Integer> length = optionalName.map(String::length);
        length.ifPresent(l -> System.out.println("Length of name: " + l));

        // 过滤值
        Optional<String> filteredName = optionalName.filter(n -> n.length() > 3);
        filteredName.ifPresent(n -> System.out.println("Filtered name: " + n));

        // 组合 Optional
        Optional<Optional<String>> nestedOptional = Optional.of(optionalName);
        Optional<String> flatOptional = nestedOptional.flatMap(o -> o);
        flatOptional.ifPresent(n -> System.out.println("Flattened name: " + n));

        // 综合示例：从一个可能为 null 的方法中获取值
        String result = getOptionalValue().orElse("Default Value");
        System.out.println("Result: " + result);
    }

    // 模拟一个可能返回 null 的方法
    public static Optional<String> getOptionalValue() {
        String value = null; // 可能为 null
        return Optional.ofNullable(value);
    }
}

