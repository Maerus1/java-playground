package com.example.reflection.reflectionapi.Repositories;

import com.example.reflection.reflectionapi.Models.Course;
import com.example.reflection.reflectionapi.Models.Student;
import com.example.reflection.reflectionapi.Util.RedisClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

// I DO want this to be a bean because I want to have Spring manage it automagically. The interface will also ensure that
// the bean gets initialized into ApplicationContext properly, and it even lets us do whatever we want after that!
@Repository
public class StudentRepo {

    private final RedisClient redisClient;

    public StudentRepo(RedisClient redisClient) {
        this.redisClient = redisClient;
    }

    public List<Student> getStudents() {
        System.out.println("Wow!");
        return List.of(Student.newStudent("Ham", "Sammich", List.of(new Course("Science"))), Student.newStudent("Meow", "Chow", List.of(new Course("Math"), new Course("Geometry"))));
    }

    public Student getStudent(String id) {
        this.redisClient.setValue(id, "Ham");
        System.out.println("Value from Redis: " + this.redisClient.getValue(id));
        Student sudent = Student.newStudent("Steve", "Jobs", List.of(new Course("Art")));

        System.out.println(sudent.getFirstName());
        return Student.newStudent("Steve", "Jobs", List.of(new Course("Art")));
    }
}
