package com.jpa.demo.cruddemo.dao;

import com.jpa.demo.cruddemo.entity.Student;
import com.jpa.demo.cruddemo.exceptions.StudentNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //define the fields for Entity Manager
    private final EntityManager entityManager;


    //inject entity Manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //implement save Method
    @Override
    @Transactional
    //This annotation is used while updating the Db, this is done so that this method can be executed within a single transaction.
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        try {
            Student result = entityManager.find(Student.class, id);
            if(result == null){
                throw new RuntimeException("No Student found");
            }
            return result;
        }catch (Exception ex){
            throw new StudentNotFoundException(ex.getMessage());
        }
    }

    @Override
    public List<Student> findAll() {
        //create Query
        TypedQuery<Student> query = entityManager.createQuery("From Student", Student.class);
        /**
         * VVIMP Note -
         * while creating a Typed query we don't use the table name or column name from the mySQL DB.
         * While creating the query, always use the fieldNames/classNames that are used in your model that is mapped to the table.
         * Hence, in the above query, we have used "Student" instead of "student".
         */
        //return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findAllOrderedByLastName() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class);
        /**
         * Note - We have used lastName in the above query, and not last_name that is actually a column in DB.
         * FROM Student ORDER BY lastName DESC
         * The above query sorts the list in desc order on the basis of lastName
         * You can also use something like "FROM Student ORDER BY lastName DESC, firstName ASC" to apply sorting based on multiple fields.
         */
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create a query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:dynamicParam", Student.class);
        //set dynamicParam
        query.setParameter("dynamicParam", lastName);
        /**
         * in a JPQL query, anything that starts with a colon(":"), is a dynamicParam
         * we can set this dynamicParam using setParameter method
         */
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        //Updates the student passed
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateUsingLastName(String lastName, String toSet) {
        //Since the below query is an Update, we don't pass Student.class
        int studentsAffected = entityManager.createQuery("Update Student s SET s.lastName=:dynamicParam1 WHERE s.lastName=:dynamicParam2")
                .setParameter("dynamicParam1", toSet)
                .setParameter("dynamicParam2", lastName)
                .executeUpdate();
//        Alternative
//        TypedQuery<Student> query = (TypedQuery<Student>) entityManager.createQuery("UPDATE Student s SET s.lastName=:dynamicParam1 WHERE s.lastName=:dynamicParam2");
//        query.setParameter("dynamicParam1", toSet);
//        query.setParameter("dynamicParam2", lastName);
//        query.executeUpdate();
        System.out.println("No. of rows Updated: " + studentsAffected);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        int rowsDeleted = entityManager.createQuery("Delete Student s where id = :dynamicParam")
                .setParameter("dynamicParam", id)
                .executeUpdate();
        System.out.println("No. of rows Deleted: " + rowsDeleted);
        //"Delete FROM Student" //->This query deletes all Students
    }

    @Override
    //@Transcational is not used here. It is handled at the service layer.
    public Student putOrUpdate(Student student) {
        return entityManager.merge(student);
    }

    //DROP TABLE IF EXISTS student; // SQL command to conditionally drop a table

    /**
     * Student student = entityManager.merge(student);
     * The above command updates the student in DB(if already present), if not, then inserts it.
     * It checks primaryKey to find whether this entry exists in DB or not.
     */
}