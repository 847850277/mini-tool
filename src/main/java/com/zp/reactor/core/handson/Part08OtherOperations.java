package com.zp.reactor.core.handson;

import com.zp.reactor.core.handson.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Part08OtherOperations {

    //========================================================================================

    Flux<User> userFluxFromStringFlux(Flux<String> usernameFlux, Flux<String> firstnameFlux, Flux<String> lastnameFlux) {
        return Flux.zip(usernameFlux, firstnameFlux, lastnameFlux)
                .map(tuple3 -> new User(tuple3.getT1(),tuple3.getT2(),tuple3.getT3()));
    }

    Mono<User> useFastestMono(Mono<User> mono1, Mono<User> mono2) {
        return Mono.first(mono1, mono2);
    }

}
