package com.jpa.demo.cruddemo.controller;

import com.jpa.demo.cruddemo.dao.StudentDAO;
import com.jpa.demo.cruddemo.entity.Student;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class Controller {
    private final StudentDAO studentDAO;
    public Controller(@NotNull StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    @GetMapping("/student")
    public Student findById(@RequestParam String id){
//        return new ResponseEntity<>(studentDAO.findById(Integer.parseInt(id)), HttpStatus.OK);
        return studentDAO.findById(Integer.parseInt(id));
    }

}
