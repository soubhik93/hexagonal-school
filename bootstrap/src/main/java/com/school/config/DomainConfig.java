package com.school.config;

import com.school.domain.SchoolService;
import com.school.infrastructure.repository.FluentJdbcRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    private final FluentJdbcRepository repository;

    public DomainConfig(FluentJdbcRepository repository) {
        this.repository = repository;
    }

    @Bean
    public SchoolService schoolService() {
        return new SchoolService(repository);
    }
}
