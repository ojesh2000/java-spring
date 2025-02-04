package Controller;

import Coaches.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    @Autowired
    public Coach c;

    @GetMapping("/")
    public String getRoot(){
        return "Hello World";
    }

    @GetMapping("/coach")
    public String advise(){
        return c.getDailyWorkout();
    }

}
