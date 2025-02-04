package com.app.aopdemo;


import com.app.aopdemo.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;

@EnableAspectJAutoProxy
public class AopdemoApplication {

	@Autowired
	private static ApplicationContext context;

	/**
	 * @param args
	 *
	 * Important Note - Only Spring Beans can be advised. That is an aspect will not work if you manually initialize it
	 * Remove the below comment to see example
	 *
	 * Spring IOC Container is responsible for managing the beans(its complete lifecycle, creation, DI etc)
	 * Spring IOC is of 2 types -> 1.) BeanFactory(Basic Features + Less memory consumption)
	 * 							   2.) ApplicationContext(Advanced Features + More memory consumption)
	 *
	 * 							   AnnotationConfigApplicationContext accepts @Component annotated classes or @Configuration annotated classes
	 */

	/**
	 * @param args
	 * @Pointcut ->In simple words whatever you specify inside @Before or @After is a pointcut expression.
	 * 				This can be extracted out into a separate method using @Pointcut annotation for better understanding, modularity and better control.
	 */

	public static void main(String[] args) throws CustomException {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AOPTest t = context.getBean("aopTest", AOPTest.class);
//		AOPTest t = new AOPTest();
//		t.hello();
//		t.hello(1L);
//		t.helloWorld();
//		t.returningHello();
//		t.throwingHello();
//		System.out.println("The result of multiplication is: " + t.aroundExample(2,3));
		System.out.println(t.jsonStringRet());
	}
}
