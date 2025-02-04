package com.jpa.jpa.otomap.dao;

import com.jpa.jpa.otomap.entity.Course;
import com.jpa.jpa.otomap.entity.Instructor;
import com.jpa.jpa.otomap.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor theInstructor);

    void update(Course theCourse);

    Course findCourseById(Integer id);

    void deleteCourseById(Integer theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);
}
