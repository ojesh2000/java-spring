package com.jpa.demo.cruddemo.service;

import com.jpa.demo.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
