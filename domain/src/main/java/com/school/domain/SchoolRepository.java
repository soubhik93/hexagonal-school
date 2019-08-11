package com.school.domain;

import com.school.domain.entities.Student;

public interface SchoolRepository {

    void save(Student student);

    Student findOne(Integer id);
}
