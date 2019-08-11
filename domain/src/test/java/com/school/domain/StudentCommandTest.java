package com.school.domain;

import com.school.domain.entities.Student;
import lombok.val;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentCommandTest {

    @Test
    public void should_convert_to_entity_when_called(){
        val command = new StudentCommand("John Snow", 404, "Winterfell");

        val actual = command.toEntity();

        assertThat(actual).isEqualToComparingFieldByField(new Student("John Snow", 404, "Winterfell"));
    }
}
