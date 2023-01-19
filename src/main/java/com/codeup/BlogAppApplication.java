package com.codeup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

@SpringBootApplication

@EntityScan(basePackages = {"com.codeup.models"})
public class BlogAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogAppApplication.class, args);
    }

}
