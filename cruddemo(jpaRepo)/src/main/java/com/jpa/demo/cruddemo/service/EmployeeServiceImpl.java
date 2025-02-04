package com.jpa.demo.cruddemo.service;

import com.jpa.demo.cruddemo.dao.EmployeeRepository;
import com.jpa.demo.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository ){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll(){return employeeRepository.findAll();}

    @Override
    public Employee findById(Integer id){return employeeRepository.findById(id).orElseGet(() -> {throw new RuntimeException("No Employee found with Id: " + id);});}

//    @Transactional
//    If we would have used entityManager, we had to put @Transactional annotation.
//    Notice we use Transactional annotation at Service layer
//    But JpaRepository anyways provide this functionality.
    @Override
    public Employee save(Employee employee){return employeeRepository.save(employee);}

//    @Transactional
    @Override
    public void deleteById(Integer id){employeeRepository.deleteById(id);}

}