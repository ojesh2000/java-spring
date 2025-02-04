package com.jpa.demo.cruddemo.dao;

import com.jpa.demo.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllOrderedByLastName();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void updateUsingLastName(String lastName, String toSet);

    void delete(Integer id);

    Student putOrUpdate(Student student);
}
