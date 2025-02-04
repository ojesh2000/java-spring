package com.app.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices for logging

    //let's start with @Before adivce

    /**
     * Pointcut - A predicate where advice should be applied.
     * This tells spring where should we run the code provided within the method of an aspect
     * Spring AOP uses AspectJ's pointcut expression language
     * different types of pointCut Expression language pattern
     * execution(modifiers-pattern? return-type-pattern declaring-type-pattern?
     * method-name-pattern(param-pattern) throws-pattern?)
     *
     * modifiers-pattern -> apply on public-protected etc type of methods
     * return-type-pattern -> apply on the method that have the specified return types
     * declaring-type-pattern -> specify the class name on which we have to apply this method
     * method-name-pattern -> you can give
     */

    @Before("execution(public void addAccount())")//this string is called a pointCut expression
    public void beforeAccountAdvice(){// we can use any method name
        System.out.println("\n======>> Executing @Before advice on addAccount()");
    }
}
