package com.app.aopdemo.aspect;

import com.app.aopdemo.annotations.Loggable;
import com.app.aopdemo.exception.CustomException;
import com.app.aopdemo.models.MyClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
@EnableAspectJAutoProxy
public class TestAspect {

    /**
     * execution is a pointCut designator(pcd)
     * Basic syntax of an execution pcd
     * @After("execution(access-modifier? return-type declaring-pkg? fun-name(params) throws-pattern)")
     * ? -> signifies optional param or not
     *
     */

//    @Before(value = "execution(* com.app.aopdemo.AOPTest.hello(Long))")
//    public void beforeHelloAspect(JoinPoint joinPoint){
//        //To get args use joinPoint Object
//        System.out.println("Before hello method with long return type and ARGS: " + Arrays.toString(joinPoint.getArgs()));
//        //To get signature of method
//        System.out.println("Method signature of this method is: " + joinPoint.getSignature());
////        System.out.println("Class which this method belongs to : " + joinPoint.getTarget().getClass());
//        /**
//         * to get the name of the method -> joinPoint.getSignature().getName()
//         * to get the class this method belongs to we use jointPoint.getTarget().getClass()
//         */
//    }
//
//    @After("execution(* com.app.aopdemo.AOPTest.hello(Long)))")
//    public void beforeAllHelloAspect(JoinPoint jp){
//        System.out.println("After hello method with long return type");
//    }

//    @Before("execution(public * com.app.aopdemo.AOPTest.hello*(..))")
//    public void beforePrefixMatcher(JoinPoint jp){
//        //The first star denotes that the returnType doesn't matter to match the pointcut
//        System.out.println("Before methods that starts with hello");
//    }

    @AfterReturning(pointcut = "afterReturningPointcut()", returning = "numValue")
    public void afterReturningHello(int numValue){
        System.out.println("Hello from after returning advice.");
        System.out.println("Value returned by the method: " + numValue);
    }

    @Pointcut("execution(* com.app.aopdemo.AOPTest.returningHello())")
    public void afterReturningPointcut(){}

    @Pointcut("execution(* com.app.aopdemo.AOPTest.throwingHello())")
    public void afterThrowingPointCut(){}

    @AfterThrowing(pointcut = "afterThrowingPointCut()", throwing = "ex")
    public void afterThrowingHello(CustomException ex){
        System.out.println("This is the exception: " + ex.getMessage());
    }

    @Pointcut("execution(int com.app.aopdemo.AOPTest.aroundExample(int, int))")
    public void aroundPointCut(){}


    //Note - the Target method is not executed(untill you manually write pjp.proceed in the advice)
    //The result of the method is returned by this advice.
    //We can also manipulate the input parameters
    @Around("aroundPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object[] requestParameters = pjp.getArgs();
        requestParameters[0] = 10;// we can modify the input
        Object res = null;
        try{
//            res = pjp.proceed(requestParameters);
            res = pjp.proceed();// if we don't send the modified input. the default input by which the method is called will be used
            //uncomment the above line to see modified result.
        } catch (Throwable e) {
            e.printStackTrace();
        }


        return res;

    }


    @Pointcut("@annotation(com.app.aopdemo.annotations.Loggable)")
    public void annotationPointCut(){}

    @Around("annotationPointCut()")
    public Object customAnnotationAdvice(ProceedingJoinPoint pjp) throws JsonProcessingException {
        Method method = this.getMethod(pjp);
        Loggable loggableAnnotation = method.getAnnotation(Loggable.class);

        Class<?> clazz = loggableAnnotation.mappingClass();
        Object result = null;
        try{
            result = pjp.proceed();
        }catch (Throwable th){
            th.printStackTrace();
        }
        ObjectMapper mp = new ObjectMapper();
        return mp.readValue((String)result, clazz).toString();
    }

    private Method getMethod(ProceedingJoinPoint pjp){
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        return methodSignature.getMethod();
    }

}
