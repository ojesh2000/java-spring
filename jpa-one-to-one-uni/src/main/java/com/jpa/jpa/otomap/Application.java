package com.jpa.jpa.otomap;

import com.jpa.jpa.otomap.dao.AppDao;
import com.jpa.jpa.otomap.dao.AppDaoImpl;
import com.jpa.jpa.otomap.entity.Instructor;
import com.jpa.jpa.otomap.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDaoImpl appDao){
		return runner -> {
//			createInstrutor(appDao);
			findInstructor(appDao);
//			deleteInstructor(appDao);
		};
	}

	private void deleteInstructor(AppDaoImpl appDao) {
		int id = 1;
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
