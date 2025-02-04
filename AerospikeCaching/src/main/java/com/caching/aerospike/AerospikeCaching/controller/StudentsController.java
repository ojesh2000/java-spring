package com.caching.aerospike.AerospikeCaching.controller;

import com.caching.aerospike.AerospikeCaching.dao.StudentsDao;
import com.caching.aerospike.AerospikeCaching.models.Student;
import com.caching.aerospike.AerospikeCaching.models.StudentList;
import com.caching.aerospike.AerospikeCaching.service.DAOService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    StudentsDao studentsDao;

    @Autowired
    DAOService studentService;
    @PostMapping("/store")
    public ResponseEntity<Boolean> insertStudent(@RequestBody Student s){
        studentsDao.insertStudent(s);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
    }


    @GetMapping("/getAllStudents")
    public ResponseEntity<StudentList> getAllStudents() throws JsonProcessingException {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        return new ResponseEntity<>(studentsDao.getStudentById(id), HttpStatus.OK);
    }
}
