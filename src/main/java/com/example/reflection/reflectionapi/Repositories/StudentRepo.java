package com.example.reflection.reflectionapi.Repositories;

import com.example.reflection.reflectionapi.Models.Books.EBook;
import com.example.reflection.reflectionapi.Models.Books.IBook;
import com.example.reflection.reflectionapi.Models.School.Course;
import com.example.reflection.reflectionapi.Models.School.Student;
import com.example.reflection.reflectionapi.Models.Books.Comic;
import com.example.reflection.reflectionapi.Models.School.StudentBuilder;
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

        // Big difference between implements and extends is that implements is for creating a contract that will be fulfilled
        // by the derived classes (Except for default and static methods), which extends provides those definitions which the child
        // classes can then add more methods for anything that's not common to all.
        Comic comic = (Comic) IBook.newBook("comIc");

        System.out.println(comic.getBookType());

        System.out.println(comic);

        Student student = Student.emptyStudent();

        student.setFirstName("Meow");

        // Builder paradigm:
        StudentBuilder studentBuilder = new StudentBuilder.Builder().firstName("Steve").lastName("Believe").build();

        System.out.println(studentBuilder.getFirstName() + " " + studentBuilder.getLastName());

        try {
            student = Student.newStudent("", "Jobs", List.of(new Course("Art")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }
}
