package com.example.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // Importez la classe LoggerFactory
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayApplication {

	private static final Logger logger = LoggerFactory.getLogger(GatewayApplication.class); // Déclarez un logger statique

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public GlobalFilter customFilter() {
		return (exchange, chain) -> {
			logger.info("Global Pre Filter executed");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("Global Post Filter executed");
			}));
		};
	}
}
