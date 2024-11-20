package com.hospital.version1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); 
        dataSource.setUrl("jdbc:mysql://localhost:3306/hospital_management"); 
        dataSource.setUsername("root"); 
        dataSource.setPassword("1234"); 

        return dataSource;
    }
}
