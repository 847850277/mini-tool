package com.zp.reactor.core;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class HelloWorld4 {

    public static void main(String[] args) {
        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });

        flux.subscribe(System.out::println);


        Flux<String> flux1 = Flux.generate(
                AtomicInteger::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next("3 x " + i + " = " + 3 * i);
                    if (i == 10) sink.complete();
                    return state;
                });

        flux1.subscribe(System.out::println);


        Flux<String> flux2 = Flux.generate(
                AtomicInteger::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next("3 x " + i + " = " + 3 * i);
                    if (i == 10) sink.complete();
                    return state;
                }, (state) -> System.out.println("state: " + state));

        flux2.subscribe(System.out::println);
    }

}
