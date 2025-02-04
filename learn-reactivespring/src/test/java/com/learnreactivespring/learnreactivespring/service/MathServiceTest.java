package com.learnreactivespring.learnreactivespring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class MathServiceTest {
    public MathService mathService;

    @BeforeEach
    void setUp(){
        mathService = new MathService();
    }
    @Test
    void mathTest(){

        mathService.mathFlux()
                        .subscribe(x -> {
                            System.out.println("Before sleep of: " + x);
                            try {
                                Thread.sleep(2000l);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("After sleep of: " + x);
                        });

        System.out.println("Completed Traversing the whole flux");


        StepVerifier.create(mathService.mathFlux())
                .expectNextCount(5)
                .verifyComplete();
    }


    @Test
    public void testFluxWithSubscribe() {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);

        flux
                .map(i -> i * 10)
                .subscribe(
                        // onNext
                        value -> System.out.println("Received value: " + value),
                        // onError
                        error -> System.err.println("Error: " + error),
                        // onComplete
                        () -> System.out.println("Processing completed")
                );

        // Assertion or verification can't be directly done here due to asynchronous nature
        // Use StepVerifier to verify Flux behavior
        StepVerifier.create(flux.map(i -> i * 10))
                .expectNext(10, 20, 30, 40, 50)
                .verifyComplete();
    }

    @Test
    public void testFluxWithBlock() {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);

        Integer result = flux
                .map(i -> i * 10)
                .reduce(0, Integer::sum)
                .block();

        System.out.println("Done");

        // Assert the result
//        assertEquals(150, result);
    }
}
