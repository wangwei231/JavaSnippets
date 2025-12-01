package com.example;
import java.util.*;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target<=nums[0]) {
            return 0;
        }
        int len = nums.length;
        if (target>=nums[len-1]) {
            return len;
        }
        int l = 0, r=len-1;
        while (l<=r) {
            int mid = (l+r)/2;
            if (target==nums[mid]) {
                return mid;
            } else if (target<nums[mid]) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i=len-1;i>=0;i--) {
            if (digits[i]!=9) {
                digits[i]++;
                for (int j=i+1;j<len;j++) {
                    digits[j]=0;
                    return digits;
                }
            }
        }
        int[] res = new int[len+1];
        res[0] = 1;
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i=0;i<len-1;i++) {
            for (int j=i+1;j<len;j++) {
                if (nums[i]+nums[j]==target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 2;
        Solution solution = new Solution();
        int res = solution.searchInsert(nums, target);
        System.out.println(res);

        int[][] matrix = {{1, 2, 0}, {4, 5, 6}, {7, 8, 9}};
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i=0;i<rows;i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<cols;j++) {
                sb.append(matrix[i][j]);
            }
            String str = sb.reverse().toString();
            System.out.println(Integer.valueOf(str));
        }
        String str = "0123";
        String reversedStr = new StringBuilder(str).reverse().toString();
        int num = Integer.valueOf(reversedStr);
        System.out.println(num);


        String s = "12345";
        String dest = "31415";
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for (int i=0;i<dest.length();i++) {
            if (!map.containsKey(dest.charAt(i))) {
                System.out.println("false");
            } else {
                if (map.get(dest.charAt(i))<=0) {
                    System.out.println("false");
                } else {
                    map.put(dest.charAt(i), map.get(dest.charAt(i))-1);
                }
            }
            
        }

        int newNum = 123;
        if (newNum>10) {
            System.out.println((newNum/10)%10);
        }


        String newStr = "1234jkj 44";
        String[] strs = newStr.split(" ");
        for (String str_ : strs) {
            System.out.println(str_);
        }
        String newStr2 = String.join(" ",strs);
        System.out.println(newStr2);
        int nDigits =0, nLower =0, nUpper=0;
        for (int i=0;i<newStr.length();i++) {
            if (Character.isDigit(newStr.charAt(i))) {
                nDigits++;
            } else if (Character.isLowerCase(newStr.charAt(i))) {
                nLower++;
            } else if (Character.isUpperCase(newStr.charAt(i))) {
                nUpper++;
            } else if (Character.isLetterOrDigit(newStr.charAt(i))) {
                System.out.println("other");
            }
        }
        String newReversedStr = new StringBuilder(newStr).reverse().toString();
        int newNum2 = Integer.valueOf(newReversedStr);
        System.out.println(newNum2);
    }
}