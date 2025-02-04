package Config;

import Coaches.Coach;
import Coaches.CricketCoach;
import Coaches.FootballCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoachConfig {

    @Bean
    public Coach cricketCoach(){
        return new CricketCoach();
    }

    /** @Bean Annotation useCases -
     * Suppose you are using a JAR and would like to use a POJO(not annotated with @Component/@Service) as a Bean in your Project.
     */

//    @Bean
//    public Coach footballCoach(){
//        return new FootballCoach();
//    }
}
