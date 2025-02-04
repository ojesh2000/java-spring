package com.jpa.jpa.otomap.dao;

import com.jpa.jpa.otomap.entity.Instructor;
import com.jpa.jpa.otomap.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
