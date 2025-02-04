package com.example.football.Annotations.Repository;

import com.example.football.Annotations.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByName(String name);

    List<Student> findByNameAndEmail(String name , String email);

    List<Student> findByNameOrEmail(String name , String email);

    List<Student> findByDepartmentDepartmentName(String deptName);

    //The names of these functions are written based on the variables defined in the model and
    //not the name of these fields inside the mongodb collection
    List<Student> findBySubjectsSubjectName(String subName);

    List<Student> findByEmailIsLike(String email);

    List<Student> findByNameStartsWith(String name);


    //Using @Query annotation
    //name of the function doesn't matter now
    //get Students by name(findByName)
    //"?0" represents the first parameter
    @Query("{\"name\" : \"?0\"}")
    List<Student> getByName(String name);

}
