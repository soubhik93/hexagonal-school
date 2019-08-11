package com.school.domain;

import com.school.domain.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentCommand {

    private String name;
    private Integer id;
    private String address;

    public Student toEntity() {
        return new Student(this.name, this.id, this.address);
    }
}
