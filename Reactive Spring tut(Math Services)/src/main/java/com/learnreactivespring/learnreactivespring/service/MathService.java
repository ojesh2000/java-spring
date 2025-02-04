package com.learnreactivespring.learnreactivespring.service;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {

    public Flux<Integer> mathFlux(){
         return Flux.just(1 , 2 , 3 , 4 , 5)
                .log()
                .map(x -> x++)
                .log();
    }

}
