package com.example.UsersServices.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ConfigBean {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // Utilisation de la force de hachage par défaut (10)
        return new BCryptPasswordEncoder();
    }


}
