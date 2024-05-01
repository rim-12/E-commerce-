package com.example.ProductsServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProductsServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsServicesApplication.class, args);
	}

}
