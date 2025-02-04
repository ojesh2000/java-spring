package com.caching.aerospike.AerospikeCaching.dao;

import com.caching.aerospike.AerospikeCaching.models.Student;
import com.caching.aerospike.AerospikeCaching.models.StudentList;

import java.util.List;

public interface StudentsDao {

    StudentList getAllStudents();

    void insertStudent(Student s);

    Student getStudentById(int id);
}
