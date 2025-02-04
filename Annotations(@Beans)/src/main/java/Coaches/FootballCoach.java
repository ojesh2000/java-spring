package Coaches;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)//Single object is created by spring and it is shared across all the classes that autowires its object.
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//Whenever a class requests to autowire an object, a new object is initialized by spring
//default scope of any class is Singleton
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice sprinting!!";
    }
}
