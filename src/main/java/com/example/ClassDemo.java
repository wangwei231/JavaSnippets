package com.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.annotation.Annotation;



public class ClassDemo {
    public static void main(String[] args) {
        User user = new User("John", "Doe");
        //get class name 
        Class<?> userClass = user.getClass();
        System.out.println(userClass.getName());
        
        try {
            //get class constructor
            Constructor<?> constructor = userClass.getConstructor(String.class, String.class);
            //new instance
            User user1 = (User) constructor.newInstance("John", "Doe");
            System.out.println(user1.getFirstName());
            System.out.println(user1.getLastName());

            //get all methods
            Method[] methods = userClass.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println("Method: " + m.getName());
            }

            //get one method
            Method workMethod = userClass.getDeclaredMethod("work", String.class);
            workMethod.invoke(user1, "coding");

            //get all fields
            Field[] fields = userClass.getDeclaredFields();
            for (Field f : fields) {
                System.out.println("Field: " + f.getName());
            }

            //get one field
            Field firstNameField = userClass.getDeclaredField("firstName");
            firstNameField.setAccessible(true);
            System.out.println("First Name: " + firstNameField.get(user1));
            //set field value
            firstNameField.set(user1, "Jane");
            System.out.println("First Name after set: " + firstNameField.get(user1));

            //get annotation
            AnnotationDemo myAnnotationDemo = userClass.getAnnotation(AnnotationDemo.class);
            System.out.println("Annotation Value: " + myAnnotationDemo.value());
            
            Annotation[] annotations = userClass.getAnnotationsByType(AnnotationDemo.class);
            for (Annotation a : annotations) {
                System.out.println("Annotation: " + a);
            }

            //get interfaces
            Class<?>[] interfaces = userClass.getInterfaces();
            for (Class<?> i : interfaces) {
                System.out.println("Interface: " + i.getName());
            }

            // 获取父类
            Class<?> superClass = userClass.getSuperclass();
            System.out.println("Superclass: " + superClass.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        

        
    }
}
