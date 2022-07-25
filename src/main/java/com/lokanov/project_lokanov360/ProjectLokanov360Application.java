package com.lokanov.project_lokanov360;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableJpaRepositories(basePackages = {"com.lokanov.project_lokanov360.repository"})
@EntityScan(basePackages = "com.lokanov.project_lokanov360.entity")
public class ProjectLokanov360Application {

	
	public static void main(String[] args) {
		SpringApplication.run(ProjectLokanov360Application.class, args);
	}

	    @Bean
	    public RequestContextListener requestContextListener() {
	        return new RequestContextListener();
	    }
	
}
	
	

