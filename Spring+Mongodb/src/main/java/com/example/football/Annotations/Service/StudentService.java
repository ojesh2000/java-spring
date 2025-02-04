package com.example.football.Annotations.Service;

import com.example.football.Annotations.Model.Student;
import com.example.football.Annotations.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student)   {
        return studentRepository.save(student);
    }

    public Student getStudentById(String id){
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateSudent(Student student){
        return studentRepository.save(student);
    }

    public String deleteStudent(String id){
        studentRepository.deleteById(id);
        return "Student has been deleted\n";
    }

    public List<Student> studentsByName(String name){
//        return studentRepository.findByName(name);
        return studentRepository.getByName(name);
    }

    public List<Student> studentsByNameAndMail(String name , String email){
        return studentRepository.findByNameAndEmail(name , email);
    }

    public List<Student> studentsByNameOrMail(String name , String email){
        return studentRepository.findByNameOrEmail(name , email);
    }

    public List<Student> allWithSorting(){
        //Sort is provided by Spring Data MongoDB
        Sort sort = Sort.by(Sort.Direction.ASC , "name" , "email");
        return studentRepository.findAll(sort);
    }

    public List<Student> byDepartmentName(String deptName){
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    public List<Student> bySubjectName(String subName){
        return studentRepository.findBySubjectsSubjectName(subName);
    }

    public List<Student> emailLike(String email){
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> nameStartsWith(String name){
        return studentRepository.findByNameStartsWith(name);
    }
}
