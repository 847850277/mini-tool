package com.zp.reactor.core;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class HelloWorld1 {

    public static void main(String[] args) {

        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        List<String> iterable = Arrays.asList("99", "66", "foobar");
        Flux<String> seq2 = Flux.fromIterable(iterable);


        Mono<String> noData = Mono.empty();
        Mono<String> data = Mono.just("foo");
        Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 7);


        Disposable subscribe = seq1.subscribe();

        //seq1.subscribe(System.out::println);

        //seq2.subscribe(System.out::println);

        seq2.subscribe(i ->{
            int i1 = Integer.parseInt(i);
            System.out.println(i1);
        },error ->{
            System.err.println(error);
        });

        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"));
    }

}
