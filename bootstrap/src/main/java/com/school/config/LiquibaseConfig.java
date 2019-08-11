package com.school.config;

import liquibase.integration.spring.SpringLiquibase;
import lombok.val;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.liquibase")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SpringLiquibase schemaLiquibase(){
        val schemaLiquibase = new SpringLiquibase();
        schemaLiquibase.setDataSource(dataSource());
        schemaLiquibase.setChangeLog("classpath:/liquibase/db.changelog.json");
        return schemaLiquibase;
    }
}
