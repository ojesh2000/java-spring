package com.learnreactivespring.learnreactivespring.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class MathService {

    public Flux<String> mathFlux(){
        return Flux.just(1 , 2 , 3 , 4 , 5)
                .log()
                .map(x -> "A" + x)
                .log();
    }
}
