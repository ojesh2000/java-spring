package com.jpa.jpa.otomap.dao;

import com.jpa.jpa.otomap.entity.Instructor;
import com.jpa.jpa.otomap.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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


}
