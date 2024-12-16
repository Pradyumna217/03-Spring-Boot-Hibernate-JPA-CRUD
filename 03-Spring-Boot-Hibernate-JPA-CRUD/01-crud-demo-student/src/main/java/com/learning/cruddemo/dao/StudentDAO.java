package com.learning.cruddemo.dao;

import com.learning.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findbyId(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    int updateByLastName();

    void delete(Integer id);

    int deleteAll();
}
