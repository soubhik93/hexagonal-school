package com.school.domain;

import com.school.domain.entities.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;


    public void create(StudentCommand command) {
        repository.save(command.toEntity());
    }

    public Student get(Integer id) {
        return repository.findOne(id);
    }
}
