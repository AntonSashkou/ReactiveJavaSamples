package com.sashkou.mono;

import reactor.core.publisher.Mono;

public class MonoSamples01 {

    public static void main(String[] args) {

        // publisher
//        Mono<Integer> mono = Mono.just(1);
//        mono.doOnNext(value -> System.out.println(value));
//        mono.subscribe(
//                value -> System.out.println(value),
//                throwable -> System.out.println(throwable.getMessage()),
//                () -> System.out.println("Completed")
//        );


        //publisher
        //publisher and his modification pipeline
        Mono<String> mono = Mono.just("value")
                .map(value -> value.toUpperCase());

        // subscriber
        // flow: subscribe -> publisher pipeline -> subscriber consumers
        mono.subscribe(
                value -> System.out.println(value),
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("Completed")
        );
    }
}
