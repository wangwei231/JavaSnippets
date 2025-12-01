package com.example;
import java.util.Arrays;

import java.util.List;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] a = {5, 3, 7, 1, 9};

        /* 1. 排序 */
        Arrays.sort(a);
        System.out.println("排序后: " + Arrays.toString(a)); // [1, 3, 5, 7, 9]

        /* 2. 二分查找（数组必须已排序） */
        int idx = Arrays.binarySearch(a, 7);
        System.out.println("7 的索引: " + idx); // 3

        /* 3. 填充 */
        int[] b = new int[5];
        Arrays.fill(b, 8);
        System.out.println("fill 后: " + Arrays.toString(b)); // [8, 8, 8, 8, 8]

        /* 4. 拷贝 & 扩容 */
        int[] c = Arrays.copyOf(a, 3);   // 截断
        int[] d = Arrays.copyOf(a, 10);  // 不足补 0
        System.out.println("copyOf(3): " + Arrays.toString(c)); // [1, 3, 5]
        System.out.println("copyOf(10): " + Arrays.toString(d)); // [1, 3, 5, 7, 9, 0, 0, 0, 0, 0]

        /* 5. 比较 */
        int[] e = {1, 3, 5, 7, 9};
        System.out.println("a 与 e 是否相等: " + Arrays.equals(a, e)); // true

        /* 6. 转 List（视图） */
        List<Integer> list = Arrays.asList(2, 4, 6);
        System.out.println("asList: " + list); // [2, 4, 6]
        // list.add(8); // 抛 UnsupportedOperationException（固定大小视图）

        Integer[] array = list.toArray(new Integer[0]);
        System.out.println("toArray: " + Arrays.toString(array)); // [2, 4, 6]

        /* 7. 并行前缀和 */
        int[] f = {1, 2, 3, 4};
        Arrays.parallelPrefix(f, (x, y) -> x + y);
        System.out.println("前缀和: " + Arrays.toString(f)); // [1, 3, 6, 10]

        /* 8. 并行排序 */
        int[] big = new int[1_000_000];
        Arrays.parallelSort(big); // 大数据量时比 sort 快
        System.out.println("并行排序 100w 个 int 完成");
    }
}
