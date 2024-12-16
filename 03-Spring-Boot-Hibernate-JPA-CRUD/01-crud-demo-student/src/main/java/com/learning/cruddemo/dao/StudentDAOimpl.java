package com.learning.cruddemo.dao;

import com.learning.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO {

//    Define Fields for EntityManager
    private EntityManager entityManager;
//    Inject entity manager using constructor injection

    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



//    implement save method


    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findbyId(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName desc",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
//        Create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student where lastName=:theData",Student.class);
//        Set Query Parameter
        theQuery.setParameter("theData",lastName);
//        return query result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public int updateByLastName() {
        int numberOfRowsUpdated = entityManager.createQuery("Update Student Set lastName = 'Patil' where lastName='Tester'").executeUpdate();
        return numberOfRowsUpdated;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numOfRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return numOfRowsDeleted;
    }


}
