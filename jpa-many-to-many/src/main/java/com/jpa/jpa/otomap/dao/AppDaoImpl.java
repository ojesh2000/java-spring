package com.jpa.jpa.otomap.dao;

import com.jpa.jpa.otomap.entity.Course;
import com.jpa.jpa.otomap.entity.Instructor;
import com.jpa.jpa.otomap.entity.InstructorDetail;
import com.jpa.jpa.otomap.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppDaoImpl implements AppDao {

    private final EntityManager entityManager;
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        //retrieve the instructor
        Instructor instructor = entityManager.find(Instructor.class, id);
        //Since the dbFetch is EAGER instructorDetail is also fetched

        //get the courses
        List<Course> courses = instructor.getCourses();
        //break association of all the courses for the instructors
        //If you don't do this you will get an exception
        for(Course x : courses){
            x.setInstructor(null);
        }
        //delete the instructor
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    /**
     * @param id - This is the id of the instructor_detail table
     * This method removes the instructorDetail and the corresponding instructor as well.
     * This is only when CascadeType.ALL is applied to the @JoinColumnAnnotation
     */
    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        //find instructor detail
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        //setting instructor to null because CascadeType.MERGE is written hence it is populated in instructor field of instructorDetail class
        //Since instructor has the details about the joinColumn we have to break the link through instructor
        //Hence, The below statement doesn't works
        //instructorDetail.setInstructor(null);
        instructorDetail.getInstructor().setInstructorDetail(null);
        //remove instructor detail
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        return entityManager.createQuery("from Course where instructor.id = :data", Course.class)
                .setParameter("data",theId)
                .getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        return entityManager.createQuery("select i from Instructor i " +
                        "JOIN FETCH i.courses " +
                        "JOIN FETCH i.instructorDetail "+
                        "where i.id = :data", Instructor.class)
                        .setParameter("data", theId)
                        .getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }

    @Override
    @Transactional
    public void update(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    public Course findCourseById(Integer id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(Integer theId) {
        //retrieve the course
        Course tempCourse = entityManager.find(Course.class, theId);
        //delete the course
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        //this will save courses as well as reviews because of CascadeType.ALL
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        return entityManager.createQuery("Select c from Course c " +
                        "JOIN FETCH c.reviews " +
                        "where c.id = :data", Course.class)
                .setParameter("data", theId)
                .getSingleResult();
    }

    @Override
    public Course findCoursesAndStudentsByCourseId(int theId) {

        return entityManager.createQuery("Select c from Course c " +
                "JOIN FETCH c.students " +
                "where c.id = :data",
                Course.class)
                .setParameter("data", theId)
                .getSingleResult();
    }

    @Override
    public Student findCoursesAndStudentsByStudentId(int theId) {
        return entityManager.createQuery("Select s from Student s " +
                "JOIN FETCH s.courses " +
                "where s.id = :data", Student.class)
                .setParameter("data", theId)
                .getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student tempStudent) {
        entityManager.merge(tempStudent);
    }
}
