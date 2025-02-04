package com.jpa.demo.cruddemo.controller;

import com.jpa.demo.cruddemo.dao.EmployeeRepository;
import com.jpa.demo.cruddemo.entity.Employee;
import com.jpa.demo.cruddemo.exceptions.EmployeeNotFoundException;
import com.jpa.demo.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private EmployeeService employeeService;

    @Autowired
    public Controller(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable(value = "id") Integer id){
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable(value = "employeeId") Integer employeeId) throws EmployeeNotFoundException {
        try {
            employeeService.findById(employeeId);
        }catch (RuntimeException ex){
            throw new EmployeeNotFoundException(ex.getMessage());
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee with Id: " + employeeId;
    }

}
