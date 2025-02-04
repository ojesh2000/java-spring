package Coaches;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return ("Practice fast bowling");
    }

    @PostConstruct
    public void afterBeanConstruction(){
        System.out.println("Bean Constructed");
    }

    @PreDestroy
    public void befroeBeanDestruction(){
        System.out.println("Bean Destroyed");
    }

}
