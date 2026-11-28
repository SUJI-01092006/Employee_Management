package com.example.securitydemo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    List<Student> students = new ArrayList<>();

    // CREATE - POST
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student added successfully";
    }

    // READ - GET ALL
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // READ - GET BY ID
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {

        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    // UPDATE - PUT
    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id,
                                @RequestBody Student student) {

        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(student.getName());
                s.setTech(student.getTech());

                return "Student updated successfully";
            }
        }

        return "Student not found";
    }

    // DELETE
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                return "Student deleted successfully";
            }
        }

        return "Student not found";
    }
}