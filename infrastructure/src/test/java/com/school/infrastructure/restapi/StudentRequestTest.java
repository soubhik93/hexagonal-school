package com.school.infrastructure.restapi;

import com.school.domain.StudentCommand;
import lombok.val;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class StudentRequestTest {

    @Test
    public void should_return_studentCommand_when_called() {
        val request = new StudentRequest("John Snow", 404, "Winterfell");

        val actual = request.toCommand();
        assertThat(actual).isEqualToComparingFieldByField(new StudentCommand("John Snow", 404, "Winterfell"));
    }
}
