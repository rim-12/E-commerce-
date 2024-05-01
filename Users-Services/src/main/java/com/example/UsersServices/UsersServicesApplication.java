package com.example.UsersServices;

import com.example.UsersServices.Entity.DTO.UserRequestDto;
import com.example.UsersServices.Enum.Role;
import com.example.UsersServices.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableFeignClients
@AllArgsConstructor
@SpringBootApplication
public class UsersServicesApplication {
	private final UserService userService;



	public static void main(String[] args) {
		SpringApplication.run(UsersServicesApplication.class, args);
	}
	@Bean
	CommandLineRunner stat(){
		return args -> {
			UserRequestDto user  = new UserRequestDto(1L,"rim.gharib@gmail.com",
					"rim","achraf123",
					"female","0621403650","achraf123" ,Role.ADMIN);

			userService.addUser(user);
		};
	}
}
