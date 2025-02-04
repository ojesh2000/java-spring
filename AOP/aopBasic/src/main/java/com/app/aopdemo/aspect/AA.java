package com.app.aopdemo.aspect;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AA implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Around Advice before code");
        Object ret = invocation.proceed();
        System.out.println("Around Advice After Code");
        return ret;
    }
}
