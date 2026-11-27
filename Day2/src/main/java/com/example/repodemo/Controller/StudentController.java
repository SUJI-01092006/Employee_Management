package com.example.repodemo.Controller;

import com.example.repodemo.Model.Student;
import com.example.repodemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {

    @Autowired
    StudentService s;

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return s.getStudents();
    }
    @PostMapping("students")
    public String addStudent(@RequestBody Student std){
        s.addStudents(std);
        return "success";
    }
    @GetMapping("students/{rno}")
    public Student getStudentByRollNo(@PathVariable int rollno){
        return s.getStudentByRoll(rollno);
    }
    @PutMapping("students")
    public String updateStudent(@RequestBody Student std){
        s.updateStudents(std);
        return "Updated";
    }
    @DeleteMapping("students/{rno}")
    public String deleteStudentByRoll(@PathVariable int rollno){
        s.deleteStudentsByRollNo(rollno);
        return "Deleted";
    }
    @DeleteMapping("students/clear")
    public String deleteAllStudents(){
        s.deleteAllStudent();
        return "Fully Deleted";
    }

    @GetMapping("students/technlogy/{tech}")
    public List<Student> getStudentsByTech(@PathVariable String tech){
        return s.getStudentBytech(tech);
    }

}
