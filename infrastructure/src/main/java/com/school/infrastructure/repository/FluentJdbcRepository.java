package com.school.infrastructure.repository;

import com.school.domain.SchoolRepository;
import com.school.domain.entities.Student;
import org.codejargon.fluentjdbc.api.FluentJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FluentJdbcRepository implements SchoolRepository {
    @Autowired
    private FluentJdbc fluentJdbc;

    @Override
    public void save(Student student) {
        fluentJdbc.query()
                .update("INSERT INTO T_STUDENT VALUES (? ,? ,?) ")
                .params(student.getName(), student.getId(), student.getAddress())
                .run();
       System.out.println("In repo");
       return;
    }

    @Override
    public Student findOne(Integer id) {
        return fluentJdbc.query().select("SELECT * FROM T_STUDENT WHERE ID = ?")
                .params(id)
                .firstResult(it -> new Student(it.getString("NAME"), it.getInt("ID"), it.getString("ADDRESS")))
                .orElse(null);

    }
}
