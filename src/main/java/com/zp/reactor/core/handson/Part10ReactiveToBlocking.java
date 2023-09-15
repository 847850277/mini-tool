package com.zp.reactor.core.handson;

import com.zp.reactor.core.handson.domain.User;
import reactor.core.publisher.Mono;

public class Part10ReactiveToBlocking {

    User monoToValue(Mono<User> mono) {
        return mono.block();
    }


}
