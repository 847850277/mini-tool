package com.zp.reactor.core;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class HelloWorld7 {

    public static void main(String[] args) {
        Flux<Long> test = Flux.interval(Duration.ofMillis(300), Schedulers.newSingle("test"));
        test.subscribe(System.out::println);

    }

}
