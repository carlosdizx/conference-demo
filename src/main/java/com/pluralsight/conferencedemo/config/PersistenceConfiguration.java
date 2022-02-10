package com.pluralsight.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public DataSource dataSource() {
        final DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName("org.postgresql.Driver");
        builder.url("jdbc:postgresql://ec2-34-206-148-196.compute-1.amazonaws.com:5432/daemo2823kt849?useSSL=false");
        builder.username("uuirazckckhsdz");
        builder.password("dd64acd045d47a1ec208bd805f26443e37f2a3587c52c13fa4bd6dd5a72b5761");
        return builder.build();
    }
}
