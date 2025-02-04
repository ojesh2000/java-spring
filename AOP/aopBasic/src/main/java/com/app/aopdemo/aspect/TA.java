package com.app.aopdemo.aspect;

import com.app.aopdemo.AOPTest;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

public class TA implements ThrowsAdvice {
    public void afterThrowing(Exception ex) throws Throwable{
        System.out.println("For Exception Handling");
//        Log l = LogFactory.getLog(AOPTest.class);
    }
}
