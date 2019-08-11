package com.school.infrastructure.restapi;

import com.school.domain.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@RestController
public class StudentController {

    private final SchoolService service;

    public StudentController(SchoolService service) {
        this.service = service;
    }

    @RequestMapping(value = "/v1.0/student", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity create(@RequestBody StudentRequest student) {
        log.info("Request received to save student {}", student.getId());
        service.create(student.toCommand());
        return status(CREATED).build();
    }

    @RequestMapping(path = "/v1.0/student", method = RequestMethod.GET)
    public ResponseEntity find(@RequestParam("rollNumber") Integer rollNumber) {
        log.info("Request received to save student {}", rollNumber);
        return status(OK).body(service.get(rollNumber));
    }
}
