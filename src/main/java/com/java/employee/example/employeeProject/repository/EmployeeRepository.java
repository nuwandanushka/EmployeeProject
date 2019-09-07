package com.java.employee.example.employeeProject.repository;

import com.java.employee.example.employeeProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
