package com.example;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)   // 关键：让注解在运行时仍存活
@Target(ElementType.TYPE)       // 可选：限制只能贴在类/接口上
public @interface AnnotationDemo {
    String value() default "myAnnotation";
}
