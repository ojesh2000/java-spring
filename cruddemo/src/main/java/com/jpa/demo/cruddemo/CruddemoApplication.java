package com.jpa.demo.cruddemo;

import com.jpa.demo.cruddemo.dao.StudentDAO;
import com.jpa.demo.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
		System.out.println("Application Started!!");
	}


	//CommandLine Runner is an interface that can be implemented by a spring bean
	//this interface provides a single method run(String... args) of type void
	//The method returned is executed after the spring boot loads the beans.
	//This allows developers to perform any necessary initialization tasks before the application is fully up and running.
	@Bean
	public CommandLineRunner commandLineRunner(@Qualifier("studentDAOImpl")StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForAllStudents(studentDAO);
//			orderedQueryForStudents(studentDAO);
//			findStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			updateUsingLastName(studentDAO);
//			deleteUsingId(studentDAO);
		};
	}

	private void deleteUsingId(StudentDAO studentDAO) {
		studentDAO.delete(6);
		System.out.println("Deleted element with id: " + 6);
	}

	private void updateUsingLastName(StudentDAO studentDAO) {
		studentDAO.updateUsingLastName("DOE", "Washington");
		System.out.println(studentDAO.findByLastName("Washington"));
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primaryKey
		int studentId = 1;
		System.out.println("Getting Student with id = " + studentId);
		Student student = studentDAO.findById(studentId);

		//change the first Name to "Scooby"
		System.out.println("Updating student in code ...");
		student.setFirstName("ojesh");
		//update the student
		System.out.println("Updating student in db....");
		studentDAO.update(student);
		//display the update student
		System.out.println(studentDAO.findById(studentId));

	}

	private void findStudentByLastName(StudentDAO studentDAO) {
		//get a List of Students
		List<Student> lastNameStudents = studentDAO.findByLastName("DOE");
		//display this list
		for(Student student: lastNameStudents){
			System.out.println(student);
		}
	}

	private void orderedQueryForStudents(StudentDAO studentDAO) {
		//get a List of Student
		List<Student> orderedStudents = studentDAO.findAllOrderedByLastName();
		//display List of Student
		for(Student student: orderedStudents){
			System.out.println(student);
		}
	}

	private void queryForAllStudents(StudentDAO studentDAO) {
		//get a List of Student
		List<Student> allStudents = studentDAO.findAll();
		//display List of Student
		for(Student student: allStudents){
			System.out.println(student);
		}
	}


	private void readStudent(StudentDAO studentDAO) {
		//create a student Object
		System.out.println("Creating the student...");
		Student tempStudent = new Student("Daffy","Duck","Daffy@gmail.com");
		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		//display the id of the saved student
		System.out.println("Saved student. The id Generated is: " + tempStudent.getId());

		//retrieve student based on id: primaryKey
		System.out.println("Retrieving the student with the givenId:" + tempStudent.getId());
		Student retrievedStudent = studentDAO.findById(tempStudent.getId());
		//display Student
		System.out.println("The retrieved student is: " + retrievedStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create dummy student object
		System.out.println("Creating new student Object....");
		Student tempStudent = new Student("Vishesh", "Sharma", "vishu@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display the id of the saved student
		System.out.println("Successfully saved the student. Its id: " + tempStudent.getId());
	}

	/**
	 * Entity Class - A class that maps to a table in the database.
	 * This class must be annotated with @Entity
	 * It must have a public/protected no-args constructor
	 * This class can have other constructor
	 */

	/**
	 * Data Access Object(DAO)
	 * Responsible for interacting with the dataBase.
	 * We will create a DAO for each table.
	 * DAO needs a JPA Entity Manager
	 * JPA Entity Manager and Data source are automatically created by spring boot using
	  		*spring.datasource.url
	  		*spring.datasource.username
	  		*spring.datasource.password
	 * 	We can autowire the JPA Entity Manager into our DAO's
	 */

	/**
	 * JPA repository can be used as an alternative to entityManager
	 * If you need low level control and high query flexibility(like writing custom queries), use Entity Manager,
	 * If you want high level of abstraction, use JPARepository
	 */

	/**
	 * To alter the starting of the autoIncrement value, we use the following sql Command.
	 * ALTER TABLE student_tracker.student AUTO_INCREMENT=3000;
	 * The above command,once executed, the id will start from 3000
	 */

	/**
	 * For querying data, JPA has JPQL(JPA Query Language)
	 * It is similar to SQL
	 * JPQL is based on entity names and entity fields, instead of table names or column names in sql
	 */

}
