package com.ht.hikingtrails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan({ "com.ht" })
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.ht.data.repository")
public class HikingtrailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HikingtrailsApplication.class, args);
	}
}