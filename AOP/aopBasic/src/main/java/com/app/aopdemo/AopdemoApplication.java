package com.app.aopdemo;


import com.app.aopdemo.aspect.AA;
import com.app.aopdemo.aspect.ARA;
import com.app.aopdemo.aspect.MBA;
import com.app.aopdemo.aspect.TA;
import org.springframework.aop.framework.ProxyFactoryBean;
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
	public CommandLineRunner cmd(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				//Add service to Business
				//Create Target
				AOPTest test = new AOPTest();
				//Create Services
				MBA s1 = new MBA();
				ARA s2 = new ARA();
				AA s3 = new AA();
				TA s4 = new TA();
				//Combine Service with Target
				ProxyFactoryBean pfb = new ProxyFactoryBean();
				pfb.setTarget(test);
				//we can also use setTargetClass for executing services for all the methods in the class
				pfb.addAdvice(s1);
				pfb.addAdvice(s2);
				pfb.addAdvice(s3);
				pfb.addAdvice(s4);
				AOPTest aopTest = (AOPTest) pfb.getObject();//This is a proxy object which now has the combined code of service + Business
				aopTest.hello();
			}
		};
	}
}
