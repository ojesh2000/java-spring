package com.example.football.Annotations.Controller;

import com.example.football.Annotations.Model.Student;
import com.example.football.Annotations.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String getRoot(){
        return "Hello World";
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        //we never pass the id as json in this post request

        return studentService.createStudent(student);
    }

    @GetMapping("/getById")
    public Student getStudentById(@RequestParam String id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/getall")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateSudent(student);
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam String id){
        return studentService.deleteStudent(id);
    }


    //Get data by a particular field
    @GetMapping("/studentsByName")
    public List<Student> studentsByName(@RequestParam String name){
        return studentService.studentsByName(name);
    }

    //AND Query
    @GetMapping("/studentsByNameAndMail")
    public List<Student> studentsByNameAndMail(@RequestParam String name , @RequestParam String email){
        return studentService.studentsByNameAndMail(name , email);
    }

    //OR Query
    @GetMapping("/studentsByNameOrMail")
    public List<Student> studentsByNameOrMail(@RequestParam String name , @RequestParam String email){
        return studentService.studentsByNameOrMail(name , email);
    }

    //Sorting documents
    @GetMapping("/allWithSorting")
    public List<Student> allWithSorting(){
        return studentService.allWithSorting();
    }

    //Getting by a sub-document field
    //getting all students whose departmentName is specified
    @GetMapping("/byDepartmentName")
    public List<Student> byDepartmentName(@RequestParam String deptName){
        return studentService.byDepartmentName(deptName);
    }

    //Getting documents based on the value of a subfield present inside an array
    //Finding all students who have Java as a subject
    @GetMapping("/bySubjectName")
    public List<Student> bySubjectName(@RequestParam String subName){
        return studentService.bySubjectName(subName);
    }

    //Getting documents whose email are like 'emailLike'(regex)
    //email : /email/
    @GetMapping("emailLike")
    public List<Student> emailLike(@RequestParam String email){
        return studentService.emailLike(email);
    }

    //Getting documents where name starts with a certain entered name
    // name : /^John/
    @GetMapping("/nameStartsWith")
    public List<Student> nameStartsWith(@RequestParam String name){
        return studentService.nameStartsWith(name);
    }
}
