package com.school.infrastructure.restapi;

import com.school.domain.StudentCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentRequest {

    private String name;
    private Integer id;
    private String address;

    public StudentCommand toCommand() {
        return new StudentCommand(name, id, address);
    }
}
