package com.example.se2tut2.controller;

import com.example.se2tut2.entity.Employee;
import com.example.se2tut2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add-employee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployeePage";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.addEmployee(employee);
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employeePage";
    }

    @GetMapping("/employee")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employeePage";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeDetails(Model model, @PathVariable Long id) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employeeDetailPage";
    }
}
