package com.kousenit.shopping_mvc.config;

import com.kousenit.shopping_mvc.controllers.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class FunctionalBeans {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(ProductHandler handler) {
        return route().path("/function",
                builder -> builder
                        .GET("", accept(APPLICATION_JSON), handler::getAllProducts)
                        .GET("/{id}", accept(APPLICATION_JSON), handler::getPersonById)
                        .POST("", handler::createProduct))
                .build();
    }
}
