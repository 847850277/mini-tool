package com.zp.reactor.core.handson;

import com.zp.reactor.core.handson.domain.User;
import com.zp.reactor.core.handson.repository.ReactiveRepository;
import com.zp.reactor.core.handson.repository.ReactiveUserRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Part06Request {

    ReactiveRepository<User> repository = new ReactiveUserRepository();

    StepVerifier requestAllExpectFour(Flux<User> flux){
        return StepVerifier.create(flux)
                .expectSubscription()
                .thenRequest(Long.MAX_VALUE)
                .expectNextCount(4)
                .expectComplete();
    }

    StepVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {
        return StepVerifier.create(flux)
                .expectNext(User.SKYLER)
                .expectNext(User.JESSE)
                .thenCancel();
    }

    Flux<User> fluxWithLog() {
        return new ReactiveUserRepository()
                .findAll()
                .log();
    }

    Flux<User> fluxWithDoOnPrintln() {
        return repository.findAll()
                .doOnSubscribe(s -> System.out.println("Starring:"))
                .doOnNext(next -> System.out.println(next.getUsername()+" "+next.getLastname()))
                .doOnComplete(() -> System.out.println("The end!"));
    }


}
