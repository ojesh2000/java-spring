package com.app.aopdemo;
//We want to apply our advices to this code.
public class AOPTest {



    public void hello(){

//        System.out.println("Hello World!!");
        throw new RuntimeException("Exception Occurred");
    }
}
