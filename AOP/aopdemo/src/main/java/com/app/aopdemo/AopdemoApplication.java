package com.app.aopdemo;

import com.app.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(AccountDAO theAccountDao){
		return runner -> {
			demoTheBeforeAdvice(theAccountDao);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao) {
		theAccountDao.addAccount();
		//doing it again to verify the aspect
		System.out.println("Let's call it Again");
		theAccountDao.addAccount();
	}

}
