package com.si.integrator.application;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.si.integrator.controller.ConsumerController;
import com.si.integrator.repository.Repository;

@EnableRabbit
@SpringBootApplication
@EnableMongoRepositories("com.si.integrator.repository")
@ComponentScan(basePackageClasses = ConsumerController.class)
public class IntegratorApplication {
		
	
    @Autowired
    Repository repository;

	public static void main(String[] args) {
		SpringApplication.run(IntegratorApplication.class, args);
	}

}
