package com.example.reflection.reflectionapi.Repositories;

import com.example.reflection.reflectionapi.Models.School.Course;
import com.example.reflection.reflectionapi.Models.School.Student;
import com.example.reflection.reflectionapi.Models.Books.Book;
import com.example.reflection.reflectionapi.Models.Books.Comic;
import com.example.reflection.reflectionapi.Util.RedisClient;
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
        List<Student> students = List.of();
        try {
            students = List.of(Student.newStudent("Sam", "Sammich", List.of(new Course("Science"))), Student.newStudent("Meow", "Chow", List.of(new Course("Math"), new Course("Geometry"))));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public Student getStudent(String id) {
        this.redisClient.setValue(id, "Ham");

        Comic comic = (Comic) Book.newBook("comIc");

        System.out.println(comic);

        Student student = Student.emptyStudent();

        student.setFirstName("Meow");

        try {
            student = Student.newStudent("", "Jobs", List.of(new Course("Art")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }
}
