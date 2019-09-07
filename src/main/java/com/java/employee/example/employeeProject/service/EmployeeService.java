package com.java.employee.example.employeeProject.service;

import com.java.employee.example.employeeProject.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee employee, Long employeeId);

    Employee addEmployee(Employee employee);

    void deleteEmployee(Long employeeId);
}
