package com.example;
import cn.hutool.core.util.StrUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Long a = 10L;
        String a1 = "  ";
        System.out.println(StrUtil.isBlank(a1));
        System.out.println(a1.length());
        System.out.println( "Hello World!" );
        System.out.println( a==10L);
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello").intern(); // 使⽤了 intern() ⽅法，指向了相同的字符串常量
        System.out.println(s1 == s2); // true，引⽤相同的字符串常量
        System.out.println(s1 == s3); // true，引⽤相同的字符串常量
    }
}
