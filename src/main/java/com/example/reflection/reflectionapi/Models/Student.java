package com.example.reflection.reflectionapi.Models;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

// This would NOT be a bean because I don't want Spring's ApplicationContext to manage this automatically
@Getter
@Setter
public class Student {

    private String firstName;

    private String lastName;

    private List<Course> classes;

    private Student(String firstName, String lastName, List<Course> classes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.classes = classes;
    }

    public static Student newStudent(String firstName, String lastName, List<Course> classes) {
        return new Student(firstName, lastName, classes);
    }
}
