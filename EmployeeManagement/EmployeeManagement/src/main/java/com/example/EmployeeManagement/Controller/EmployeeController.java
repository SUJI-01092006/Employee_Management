package com.example.EmployeeManagement.Controller;

import com.example.EmployeeManagement.Model.Employee;
import com.example.EmployeeManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService s;

    // READ
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return s.getAllEmployees();
    }

    // CREATE
    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee e) {
        s.addEmployee(e);
    }

    // UPDATE
    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee e) {
        s.updateEmployee(e);
    }

    // DELETE
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        s.deleteEmployee(id);
    }
}
