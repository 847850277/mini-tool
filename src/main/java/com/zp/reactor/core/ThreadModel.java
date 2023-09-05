package com.zp.reactor.core;

import reactor.core.publisher.Flux;

public class ThreadModel {

    public static void main(String[] args) {
        Flux<Integer> range = Flux.range(1, 10000);
        //range.subscribeOn()
        //range.publishOn()
    }

}
