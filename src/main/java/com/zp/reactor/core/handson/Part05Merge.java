package com.zp.reactor.core.handson;

import com.zp.reactor.core.handson.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Part05Merge {

    Flux<User> mergeFluxWithInterleave(Flux<User> flux1, Flux<User> flux2) {
        return Flux.merge(flux1,flux2);
        //return flux1.mergeWith(flux2);
    }

    Flux<User> mergeFluxWithNoInterleave(Flux<User> flux1, Flux<User> flux2) {
        //return Flux.concat(flux1, flux2);
        //eturn Flux.concat(flux1, flux2);
        return flux1.concatWith(flux2);
    }

    Flux<User> createFluxFromMultipleMono(Mono<User> mono1, Mono<User> mono2) {
        //return mono1.concatWith(mono2);
        return Flux.concat(mono1,mono2);
    }

}
