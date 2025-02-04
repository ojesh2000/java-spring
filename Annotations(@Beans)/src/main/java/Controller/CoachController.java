package Controller;

import Coaches.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    @Autowired
    @Qualifier("cricketCoach")public Coach c;

    @Autowired
    @Qualifier("cricketCoach")private Coach anotherCoach;

    @GetMapping("/")
    public String getRoot(){
        return "Hello World";
    }

    @GetMapping("/coach")
    public String advise(){
        return c.getDailyWorkout();
    }

    @GetMapping("/checkEquality")
    public Boolean check(){
        return c == anotherCoach;
    }

}
