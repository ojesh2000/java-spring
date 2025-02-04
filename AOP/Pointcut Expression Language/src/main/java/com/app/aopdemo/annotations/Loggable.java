package com.app.aopdemo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//has runtime visibility, and we can apply it to types (methods).
//ElementType.TYPE indicates that this annotation can be applied to classes
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Loggable {
    Class<?> mappingClass();
}
