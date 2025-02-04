package com.app.aopdemo.aspect;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class ARA implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Hello from After Returning Advice");
    }
}
