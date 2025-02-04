package com.learnreactivespring.learnreactivespring;

import com.learnreactivespring.learnreactivespring.service.MathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
public class MathServiceTests {
    public MathService mathService;

    @BeforeEach
    void setUp(){
        mathService = new MathService();
    }


    @Test
    void MathServiceTest(){
//        mathService.mathFlux()
//                .subscribe(x -> System.out.println("This has now reached subscibe: " + x));
        StepVerifier.create(mathService.mathFlux())
                .expectNextCount(5)
                .verifyComplete();

    }
}
