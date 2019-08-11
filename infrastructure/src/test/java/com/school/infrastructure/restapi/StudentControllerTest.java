package com.school.infrastructure.restapi;

import com.school.domain.SchoolService;
import com.school.domain.StudentCommand;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

    @Mock
    private SchoolService service;

    @InjectMocks
    StudentController controller;

    @Test
    public void should_call_service_to_save_when_controller_is_invoked() {
        val request = new StudentRequest("John Snow", 404, "Winterfell");
        controller.create(request);

        verify(service).create(any(StudentCommand.class));
    }

    @Test
    public void should_call_service_to_get_student_by_roll() {
        controller.find(1234);

        verify(service).get(1234);
    }
}
