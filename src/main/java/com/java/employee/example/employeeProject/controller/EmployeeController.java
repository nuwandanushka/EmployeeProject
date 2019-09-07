package com.java.employee.example.employeeProject.controller;

import com.java.employee.example.employeeProject.model.Employee;
import com.java.employee.example.employeeProject.service.EmployeeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        if (null == employee) {
            LOGGER.error("employee Id " + id + " is not existed");
            return new Employee();
        }
        return employee;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        LOGGER.info("called addEmployee");
        return employeeService.addEmployee(employee);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable(value = "id") long employeeId) {
        LOGGER.info("called updateEmployee()");
        return ResponseEntity.ok().body(employeeService.updateEmployee(employee,employeeId));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        LOGGER.info("called deleteById()");
        employeeService.deleteEmployee(employeeId);
    }



}
