package com.jpa.jpa.otomap.dao;

import com.jpa.jpa.otomap.entity.Instructor;
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


}
