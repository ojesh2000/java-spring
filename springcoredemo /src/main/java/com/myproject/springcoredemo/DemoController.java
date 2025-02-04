package com.myproject.springcoredemo;

import com.myproject.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field
    private Coach myCoach;

    //If we have only one constructor, autowired is optional
    //constructor injection
//    @Autowired
//    public DemoController(Coach coach){
//        myCoach = coach;
//    }

    //setter injecttion
    @Autowired
    public void setMyCoach(Coach coach){
        myCoach = coach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }



}
