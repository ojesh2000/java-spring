package com.example.football.Annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.football.Annotations.Repository")
public class AnnotationsApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(AnnotationsApplication.class, args);

	}

}
