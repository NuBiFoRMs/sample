package com.nubiform.webflux;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class HelloWordHandler {

    public Mono<ServerResponse> helloWorld(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(Mono.just(HelloWorld.builder()
                .id(1)
                .title("title")
                .message("message")
                .build()), HelloWorld.class);
    }
}
