package com.sashkou.mono;

import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class MonoSamples02 {

    public static void main(String[] args) {

//        // just - executes method immideatly (not lazy)
//        Mono<String> justPublisher = Mono.just(getData());

//        // from supplier executes method on demand (lazy)
//        Mono<String> fromSupplierPublisher = Mono.fromSupplier(() -> getData());
//        fromSupplierPublisher.subscribe(data -> System.out.println(data));

//        // from supplier example as function
//        Mono<String> fromSupplier = Mono.fromSupplier(getDataFromSupplier());
//        fromSupplier.subscribe(data -> System.out.println(data));

//        // from future example
//        Mono<String> fromFuture = Mono.fromFuture(getDataFromCompletableFuture());
//        fromFuture.subscribe(data -> System.out.println(data));

//        // from runnable example
//        Mono<Object> fromRunnable = Mono.fromRunnable(getDataFromRunnable());
//        fromRunnable.subscribe(
//                stub -> System.out.println(stub),
//                throwable -> System.out.println(throwable.getMessage()),
//                () -> System.out.println("Completed")
//        );

    }

    private static String getData() {
        System.out.println("Generating data...");
        return UUID.randomUUID().toString();
    }

    private static Supplier<String> getDataFromSupplier() {
        return () -> getData();
    }

    private static CompletableFuture<String> getDataFromCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> getData());
    }

    private static Runnable getDataFromRunnable() {
        return () -> System.out.println(getData());
    }
}
