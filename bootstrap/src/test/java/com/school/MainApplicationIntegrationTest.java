package com.school;

import com.school.infrastructure.repository.FluentJdbcRepository;
import com.school.infrastructure.restapi.StudentController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTest
@RunWith(SpringRunner.class)
public class MainApplicationIntegrationTest {

    @Autowired
    private StudentController studentController;

    @Autowired
    private FluentJdbcRepository fluentJdbcRepository;

    @Test
    public void should_create_an_controller() {
        assertThat(studentController).isNotNull();
    }

    @Test
    public void should_create_an_repository() {
        assertThat(fluentJdbcRepository).isNotNull();
    }
}
