package com.luv2code.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	/**
	 * Adding spring-boot-starter-security in pom.xml, secures all the endpoints by default.
	 * Try opening the following url in browser
	 * http://localhost:8080/api/employees
	 * The default userName is user for this package
	 * password is generated in logs
	 * to override the default userName and password, set the following properties in application.properties
	 * 			1) spring.security.user.name=scott
	 * 			2) spring.security.user.password=test123
	 */

}
