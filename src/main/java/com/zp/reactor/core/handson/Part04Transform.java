package com.zp.reactor.core.handson;

import com.zp.reactor.core.handson.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Part04Transform {

    Mono<User> capitalizeOne(Mono<User> mono){
        return mono.map(user -> new User(user.getUsername().toUpperCase(),
                user.getFirstname().toUpperCase(),
                user.getLastname().toUpperCase()));

    }

    Flux<User> capitalizeMany(Flux<User> flux) {
        return flux.map(user -> new User(user.getUsername().toUpperCase(),
                user.getFirstname().toUpperCase(),
                user.getLastname().toUpperCase()));
    }

    Flux<User> asyncCapitalizeMany(Flux<User> flux) {
        return flux.flatMap(this::asyncCapitalizeUser);
    }


    Mono<User> asyncCapitalizeUser(User u) {
        return Mono.just(new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase()));
    }

}
