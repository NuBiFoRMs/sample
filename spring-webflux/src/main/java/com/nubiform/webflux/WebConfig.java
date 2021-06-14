package com.nubiform.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
@EnableWebFlux
public class WebConfig {

    @Bean
    public RouterFunction<ServerResponse> routeHelloWorld(HelloWordHandler handler) {
        return RouterFunctions.route(GET("/hello-world"), handler::helloWorld);
    }

    @Bean
    public RouterFunction<ServerResponse> routeHello() {
        return RouterFunctions.route(GET("/hello"),
                request -> {
                    return ServerResponse.ok().body(BodyInserters.fromValue("Hello world"));
                });
    }
}
