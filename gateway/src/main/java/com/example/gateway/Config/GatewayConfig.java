package com.example.gateway.Config;

import com.example.gateway.filter.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class GatewayConfig {
    private final JwtAuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("Users-Services", r -> r.path("/users/**")
                        .uri("lb://Users-Services"))
                .route("auth-service", r -> r.path("/auth/**")
                        .uri("lb://auth-service"))
                .route("Order-Services", r -> r.path("/order/**")
                        .uri("lb://Order-Services"))
                .route("Paiement-Services", r -> r.path("/paiement/**")
                        .uri("lb://Paiement-Services"))
                .route("Products-Services", r -> r.path("/catalogs/**")
                        .uri("lb://Products-Services"))
                .build();
    }
}