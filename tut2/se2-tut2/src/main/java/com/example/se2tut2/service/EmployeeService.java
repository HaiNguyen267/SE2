package com.example.se2tut2.service;

import com.example.se2tut2.entity.Employee;
import com.example.se2tut2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
