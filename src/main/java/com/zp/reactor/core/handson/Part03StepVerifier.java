package com.zp.reactor.core.handson;

import com.zp.reactor.core.handson.domain.User;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Part03StepVerifier {

    void expectFooBarComplete(Flux<String> flux){
        StepVerifier.create(flux)
                .expectNext("foo")
                .expectNext("bar")
                .verifyComplete();
    }


    void expectFooBarError(Flux<String> flux){
        StepVerifier.create(flux)
                .expectNext("foo")
                .expectNext("bar")
                .expectError(RuntimeException.class);
    }

    void expectSkylerJesseComplete(Flux<User> flux){
        StepVerifier.create(flux)
                .assertNext(u -> assertEquals(u.getUsername(),"swhite"))
                .assertNext(u -> assertEquals(u.getUsername(),"jpinkman"))
                .verifyComplete();

    }

    void expect10Elements(Flux<Long> flux) {
        StepVerifier.create(flux)
                .expectNextCount(10L)
                .verifyComplete();
    }


    void expect3600Elements(Supplier<Flux<Long>> supplier) {
        StepVerifier.withVirtualTime(supplier)
                .thenAwait(Duration.ofSeconds(3600))
                .expectNextCount(3600)
                .verifyComplete();

    }

}
