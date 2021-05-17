package com.nubiform.webflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.Logger;

import java.util.List;

@Slf4j
@Component
public class AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("start");

//        Mono<String> body = httpGet(); // cold
//        Mono<String> body = httpGet().cache(); // hot
        Mono<String> body = httpGet().cache();

        body.subscribe(s -> log.info("Subscriber 1: {}", s.length()));
        body.subscribe(s -> log.info("Subscriber 2: {}", s.length()));

        log.info("finish");
    }

    public Mono<String> httpGet() {
        return WebClient.create()
                .get()
                .uri("https://jsonplaceholder.typicode.com/users")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .log();
    }
}
