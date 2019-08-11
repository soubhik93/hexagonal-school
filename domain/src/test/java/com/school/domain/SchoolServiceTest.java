package com.school.domain;

import com.school.domain.entities.Student;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SchoolServiceTest {

    @Mock
    private SchoolRepository repository;

    @InjectMocks
    private SchoolService service;

    @Test
    public void should_call_repository_to_save_student_details() {
        val argumentCapture = ArgumentCaptor.forClass(Student.class);
        val command = new StudentCommand("John Snow", 404, "Winterfell");
        service.create(command);

        verify(repository).save(argumentCapture.capture());

        assertThat(argumentCapture.getValue()).isEqualToComparingFieldByField(new Student("John Snow", 404, "Winterfell"));
    }
}
