package com.example;

import java.util.Iterator;

@AnnotationDemo(value="user")
public class User implements Iterable<String> {
    private String firstName;
    private String lastName;
    private String[] hobbies;
    
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbies = new String[]{"reading", "swimming"};
    }

    @Override
    public Iterator<String> iterator() {
        return new HobbyIterator();
    }

    public class HobbyIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < hobbies.length;
        }

        @Override
        public String next() {
            return hobbies[index++];
        }
    }

    public String getAnnotationValue() {
        AnnotationDemo annotation = this.getClass().getAnnotation(AnnotationDemo.class);
        return annotation.value();
    }

    public void work(String task) {
        System.out.println("User is working on " + task);
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
