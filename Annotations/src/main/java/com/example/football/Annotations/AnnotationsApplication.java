package com.example.football.Annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"Coaches" , "Controller"})
public class AnnotationsApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(AnnotationsApplication.class, args);

	}

}
