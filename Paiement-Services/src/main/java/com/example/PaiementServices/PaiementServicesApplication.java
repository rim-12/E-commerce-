package com.example.PaiementServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PaiementServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaiementServicesApplication.class, args);
	}

}
