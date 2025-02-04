package com.jpa.jpa.otomap;

import com.jpa.jpa.otomap.dao.AppDao;
import com.jpa.jpa.otomap.dao.AppDaoImpl;
import com.jpa.jpa.otomap.entity.Course;
import com.jpa.jpa.otomap.entity.Instructor;
import com.jpa.jpa.otomap.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.RouteMatcher;

import java.util.List;
import java.util.zip.CheckedOutputStream;

/**
 * Eager loading will load all dependent entities
 * Loading Instructor will load all the courses too.
 * This will surely slow down our application
 * In general, we should load data only when needed.
 * This is called Lazy-Loading
 */

/**
 * Default fetchTypes for different annotations -
 * @OneToOne - FetchType.EAGER
 * @OneToMany - FetchType.LAZY
 * @ManyToOne - FetchType.EAGER
 * @OneToMany - FetchType.LAZY
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDaoImpl appDao){
		return runner -> {
//			createInstrutor(appDao);
//			findInstructor(appDao);
			deleteInstructor(appDao);
//			findInstructorDetail(appDao);
//			deleteInstructorDetail(appDao);
//			createInstrutorWithCourses(appDao);
//			findInstructorWithCourses(appDao);
//			findCoursesForInstructor(appDao);
//			findInstructorWithCoursesJoinFetch(appDao);
//			updateInstructor(appDao);
//			updateCourse(appDao);
		};
	}

	private void updateCourse(AppDaoImpl appDao) {
		int theId = 14;

		//find the course
		System.out.println("Finding the course with Id - " + theId);
		Course tempCourse = appDao.findCourseById(theId);

		//update the course
		System.out.println("Updating the course: " + theId);
		tempCourse.setTitle("Enjoy little Things");

		appDao.update(tempCourse);
		System.out.println("Done!!");
	}

	private void updateInstructor(AppDaoImpl appDao) {
		//find the instructor
		int theId = 3;
		System.out.println("Finding Instructor: " + theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);

		//update the instructor
		System.out.println("Updating Instructor with id: " + theId);
		tempInstructor.setLastName("Tester");

		appDao.update(tempInstructor);
		System.out.println("Done");
	}

	/**
	 * @param appDao
	 * Single db Query to load Instructor and their corresponding courses(using instructor's id)
	 * while maintaining Lazy fetchType
	 */
	private void findInstructorWithCoursesJoinFetch(AppDaoImpl appDao) {
		int theId = 3;
		System.out.println("Finding Instructor Id: " + theId);
		Instructor tempInstructor = appDao.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("Corresponding courses: " + tempInstructor.getCourses());
		System.out.println("Done!!");
	}


	/**
	 * @param appDao
	 * This solution is Okay, but it requires us to fetch instructor first and then fetch courses.
	 * This is not feasible, as we can do
	 * Get Instructor and courses in a single query while keeping the fetchType as LAZY
	 */
	private void findCoursesForInstructor(AppDaoImpl appDao) {
		int theId = 3;
		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDao.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		//find Courses for Instructor
		//This method can be used if we lazily initialize the Instructor and not get any courses
		System.out.println("Finding courses for instructor with id: " + theId);
		List<Course> courses = appDao.findCoursesByInstructorId(theId);

		//associating the courses with the instructor
		tempInstructor.setCourses(courses);

		System.out.println("The associated Courses: " + tempInstructor.getCourses());

	}

	private void findInstructorWithCourses(AppDaoImpl appDao) {
		int theId = 3;
		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDao.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		//if fetch = FetchType.LAZY below line will throw exception as we could not lazily load the courses associated to the instructor.
		//Hence, This method can not be used if we use lazy initialization of courses.
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstrutorWithCourses(AppDaoImpl appDao) {
		//create Instructor
		Instructor instructor = new Instructor("Susan", "Public", "susan@luv2code.com");

		//create InstructorDetail
		InstructorDetail instructorDetail = new InstructorDetail(
				"http://www.youtube.com",
				"Video Games"
		);


		//associate the instructor and instructorDetail
		instructor.setInstructorDetail(instructorDetail);


		//create some courses
		Course tempCourse1 = new Course("Air Guitar- The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball MasterClass");

		//add courses to the instructor
		instructor.add(tempCourse1);
		instructor.add(tempCourse2);

		//save the instructor
		/**
		 * Note - This will also save the courses beacuase we have CascadeType.PERSIST
		 */
		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());
		appDao.save(instructor);
		System.out.println("Done");

	}

	private void deleteInstructorDetail(AppDaoImpl appDao) {
		int instructorDetailId = 4;
		System.out.println("Deleting instructor Detail and Corresponding instructor with instructorDetailId = " + instructorDetailId);
		//Only deleting instructorDetail without deleting the instructor

		appDao.deleteInstructorDetailById(instructorDetailId);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDaoImpl appDao) {
		//biDirectional Logic
		//get the instructorDetail object
		int instructorDetailId = 2;//Note - This is instructorDetail table's id
		InstructorDetail instructorDetail = appDao.findInstructorDetailById(instructorDetailId);

		//print the instructorDetail
		System.out.println("tempInstructorDetails: " + instructorDetail);

		//print the associated instructor
		System.out.println("the associated instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDaoImpl appDao) {
		int id = 3;
		System.out.println("Deleting instructor with id: " + id);

		appDao.deleteInstructorById(id);

		/**
		 * Since we used CascadeType.ALL, the corresponding instructorDetail will also be deleted.
		 */
		System.out.println("Deleted instructor and instructorDetail with id:" + id);
	}

	private void findInstructor(AppDaoImpl appDao) {
		int id = 2;
		System.out.println("Finding Instructor by ID: " + id);

		Instructor instructor = appDao.findInstructorById(id);

		/**
		 * This subscription to db is eager.
		 * this means that the corresponding instructorDetails will also be fetched along with instructorDetails.
		 */
		System.out.println("required Instructor is: " + instructor);
		System.out.println("the instructorDetails is: " + instructor.getInstructorDetail());
	}

	private void createInstrutor(AppDao appDao) {
		/**
		 * It inserts the instrcutorDetail first as to insert an Instructor it needs to know the instructorDetail first(it is a column in instructor table)
		 */
//		//create Instructor
//		Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//		//create InstructorDetail
//		InstructorDetail instructorDetail = new InstructorDetail(
//				"http://www.luv2code.com/youtube",
//				"Luv 2 Code!!"
//		);

		//create Instructor
		Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		//create InstructorDetail
		InstructorDetail instructorDetail = new InstructorDetail(
				"http://www.luv2code.com/youtube",
				"Guitar"
		);


		//associate the instructor and instructorDetail
		instructor.setInstructorDetail(instructorDetail);


		//save the instructor
		/**
		 * Note - This will also save the instructorDetails object in instructor_detail table because of
		 * CascadeType.All
		 */
		System.out.println("Saving the Instructor: " + instructor);
		appDao.save(instructor);
		System.out.println("Done!!");
	}

	/**
	 * We can make our One To One Relationship bidirectional as well.
	 * Currently in our app, only Instructor can access InstructorDetail and not vice-versa
	 * No changes are required in Database Schema
	 */

}
