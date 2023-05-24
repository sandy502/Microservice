package com.freecharge.gateway.ApiGateway.Configurations;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myConfig {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p.path("/users/**")
                        .uri("lb://USER-SERVICE"))
                .route(p->p.path("/hotels/**")
                        .uri("lb://HOTEL-SERVICE"))
                .route(p->p.path("/ratings/**").uri("lb://RATING-SERVICE"))
                .build();
    }

}
