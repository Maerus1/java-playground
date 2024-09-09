package com.example.reflection.reflectionapi.Controller;

import com.example.reflection.reflectionapi.Models.Student;
import com.example.reflection.reflectionapi.Repositories.StudentRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final StudentRepo studentRepo;

    public MainController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping("/")
    public String getValue() {
        return "Hello, world";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentRepo.getStudents();
    }

    /**
     * @param id /student?id=value
     * @return a single Student object
     */
    @GetMapping("/student")
    public Student getStudent(@RequestParam(value = "id") String id) {
        return this.studentRepo.getStudent(id);
    }
}
