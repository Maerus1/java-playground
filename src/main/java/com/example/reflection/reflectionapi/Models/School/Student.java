package com.example.reflection.reflectionapi.Models.School;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

// This would NOT be a bean because I don't want Spring's ApplicationContext to manage this automatically
@Getter
@Setter
public class Student {

    private String firstName;

    private String lastName;

    private List<Course> classes;

    private static volatile Student singletonInstance = null;

    private Student(String firstName, String lastName, List<Course> classes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.classes = classes;
    }

    public static Student emptyStudent() {
        return new Student("", "", List.of());
    }

    public static Student createSingletonStudent(String firstName, String lastName, List<Course> classes) {
        if (singletonInstance == null) {
            synchronized (Student.class) {
                if (singletonInstance == null) {
                    singletonInstance = new Student(firstName, lastName, classes);
                }
            }
        }

        return singletonInstance;
    }

    // This is a factory method using a class. This may not be an example where it makes sense to use an interface
    public static Student newStudent(String firstName, String lastName, List<Course> classes) throws IllegalArgumentException {
//        if (instance == null) {
//            synchronized (Student.class) {
//                if (instance == null) {
//                    instance = new Student(firstName, lastName, classes);
//                }
//            }
//        }
//        return instance;

        if (firstName.isEmpty() || lastName.isEmpty() || classes.isEmpty()) {
            throw new IllegalArgumentException("All students must have at least one class, a first name and a last name");
        }

        return new Student(firstName, lastName, classes);
    }

}
