package com.learnreactivespring.learnreactivespring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.time.Duration;

@RestController
public class FluxAndMonoController {
    @GetMapping("/flux")//Whenever browser hits this endpoint, it acts like a subscriber waiting for data
    public Flux<Integer> returnFlux(){
        //Since our browser expects a json result, it waits for 4 seconds
        return Flux.just(1 , 2 , 3 , 4)
                .delayElements(Duration.ofSeconds(1))
                .log();
    }

    @GetMapping(value = "/fluxstream" , produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> returnFluxStream(){
        //to remove the 4 second wait, we tell the browser to expect a stream of values.
        return Flux.just(1 , 2 , 3 , 4)
                .delayElements(Duration.ofSeconds(1))
                .log();
    }
}
