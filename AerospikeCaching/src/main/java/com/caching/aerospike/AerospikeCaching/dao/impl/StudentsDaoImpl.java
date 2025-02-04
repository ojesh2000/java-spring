package com.caching.aerospike.AerospikeCaching.dao.impl;

import com.caching.aerospike.AerospikeCaching.dao.StudentsDao;
import com.caching.aerospike.AerospikeCaching.models.Student;
import com.caching.aerospike.AerospikeCaching.models.StudentList;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentsDaoImpl implements StudentsDao {

    @Autowired
    private EntityManager entityManager;
    @Override
    public StudentList getAllStudents() {
        try {
            List<Student> students = entityManager.createQuery("select s from Student s", Student.class).getResultList();
            return new StudentList(students);
        }catch (Exception ex){
            throw new RuntimeException("Error fetching all Students:"+ ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void insertStudent(Student s) {
        try {
            entityManager.persist(s);
        }catch (Exception ex){
            throw new RuntimeException("Error storing student: " + ex.getMessage());
        }
    }

    @Override
    public Student getStudentById(int id) {
        try {
            return entityManager.createQuery("select s from Student s where id = :id", Student.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (Exception ex){
            throw new RuntimeException("Error fetching student by id: " + ex.getMessage());
        }
    }
}
