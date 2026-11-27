package com.example.repodemo.Service;

import com.example.repodemo.Model.Student;
import com.example.repodemo.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo r;


    public List<Student> getStudents() {
        return r.findAll();

    }

    public void addStudents(Student std) {
        r.save(std);
    }

    public Student getStudentByRoll(int rollno) {
        return r.findById(rollno).orElse(new Student());
    }

    public void updateStudents(Student std) {
        r.save(std);
    }

    public void deleteStudentsByRollNo(int rollno) {
        r.deleteById(rollno);
    }

    public void deleteAllStudent() {
        r.deleteAll();
    }

    public List<Student> getStudentBytech(String tech) {
        return r.findBytech(tech);
    }
}
