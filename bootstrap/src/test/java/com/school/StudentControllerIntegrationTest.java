package com.school;

import com.school.domain.entities.Student;
import com.school.infrastructure.repository.FluentJdbcRepository;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTest
@RunWith(SpringRunner.class)
public class StudentControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FluentJdbcRepository repository;


    @Test
    public void should_create_student_details_when_post_request() throws Exception {

        val request = post("/v1.0/student")
                .contentType(APPLICATION_JSON)
                .content("{ \"name\": \"Thanos\", \"id\": 1001, \"address\": \"Earth\" }");
        // When
        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Then
        val created = repository.findOne(1001);
        assertThat(created.getName()).isEqualTo("Thanos");
    }

    @Test
    public void should_get_student_details_when_find() throws Exception {
      repository.save(new Student("Tony Stark", 101, "Hell"));

        val request = get("/v1.0/student?rollNumber="+101)
                .contentType(APPLICATION_JSON);
        // When
        val response = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Then
        assertThat(response).isEqualTo("{\"name\":\"Tony Stark\",\"id\":101,\"address\":\"Hell\"}");
    }


}
