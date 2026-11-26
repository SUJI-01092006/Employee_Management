package com.example.EmployeeManagement.Service;

import com.example.EmployeeManagement.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> list = new ArrayList<>(Arrays.asList(
            new Employee(1, "Suji", "IT", 30000),
            new Employee(2, "Arun", "HR", 25000),
            new Employee(3, "Priya", "Finance", 35000)
    ));

    // READ - Get all employees
    public List<Employee> getAllEmployees() {
        return list;
    }

    // CREATE - Add employee
    public void addEmployee(Employee e) {
        list.add(e);
    }

    // UPDATE - Update employee
    public void updateEmployee(Employee e) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == e.getId()) {
                list.set(i, e);
                return;
            }
        }
    }

    // DELETE - Delete employee
    public void deleteEmployee(int id) {
        list.removeIf(e -> e.getId() == id);
    }

}
