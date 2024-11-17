package com.tbd_grupo8.control2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("postgres")
    private String dbPassword;

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(dbUrl, dbUsername, dbPassword);
    }
}