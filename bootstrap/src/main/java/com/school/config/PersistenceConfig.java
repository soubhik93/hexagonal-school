package com.school.config;

import org.codejargon.fluentjdbc.api.FluentJdbc;
import org.codejargon.fluentjdbc.api.FluentJdbcBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public FluentJdbc fluentJdbc(){
        return new FluentJdbcBuilder()
                .connectionProvider(dataSource)
                .build();
    }
}
