package com.learnreactivespring.learnreactivespring.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest//Scans all the classes like @RestController , @Controller etc
//Does not scan @Component , @Server , @Repository
public class FluxAndMonoControllerTest {
    @Autowired
    WebTestClient webTestClient;
}
