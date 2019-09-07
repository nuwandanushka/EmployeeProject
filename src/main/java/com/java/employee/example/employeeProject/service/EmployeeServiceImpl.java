package com.java.employee.example.employeeProject.service;

import com.java.employee.example.employeeProject.model.Employee;
import com.java.employee.example.employeeProject.repository.EmployeeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long employeeId) {
        if (null != getEmployeeById(employeeId)) {
            LOGGER.error("Id " + employeeId + " is not existed");
            return new Employee();
        }
        return addEmployee(employee);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        if (null != getEmployeeById(employeeId)) {
            LOGGER.error("Id " + employeeId + " is not existed");
            return;
        }
        employeeRepository.delete(employeeId);
    }
}
