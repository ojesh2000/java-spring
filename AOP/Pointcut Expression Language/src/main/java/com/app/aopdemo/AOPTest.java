package com.app.aopdemo;

import com.app.aopdemo.annotations.Loggable;
import com.app.aopdemo.exception.CustomException;
import com.app.aopdemo.models.MyClass;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//We want to apply our advices to this code.
@Component("aopTest")
public class AOPTest {



    public void hello(){

        System.out.println("This is hello method with no params");
//        throw new RuntimeException("Exception Occurred");
    }

    public void hello(Long x){
        System.out.println("hello method with param: " + x);
    }

    public void helloWorld(){
        System.out.println("This is helloWorld method");
    }

    public int returningHello(){
        int a = 1;
        System.out.println("This method returns: " + a);
        return a;
    }

    public void throwingHello() throws CustomException {
        throw new CustomException("This is throwing hello");
    }

    public int aroundExample(int x, int y){
        System.out.println("Inside aroundExample method: " + x + "    *     " + y);
        return x * y;
    }

    //Example of custom annotations
    @Loggable(mappingClass = MyClass.class)
    public String jsonStringRet(){
        System.out.println("Inside jsonStringRet method");
        return "{\"name\": \"Ojesh\", \"value\": 1}";
    }
}
