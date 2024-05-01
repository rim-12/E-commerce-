package com.example.AuthentificationSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthentificationSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthentificationSecurityApplication.class, args);
	}

}
