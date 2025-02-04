package com.jpa.jpa.otomap.dao;

import com.jpa.jpa.otomap.entity.Instructor;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
