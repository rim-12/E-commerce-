package com.example.AuthentificationSecurity.client;

import com.example.AuthentificationSecurity.Request.RegisterRequest;
import com.example.AuthentificationSecurity.dto.RegisterDto;
import com.example.AuthentificationSecurity.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "Users-Services")
public interface UserServiceClient {
    @PostMapping("/users/create")
    ResponseEntity<RegisterDto> save(@RequestBody RegisterRequest request);

    @GetMapping("/users/email={email}")
    ResponseEntity<UserDto> getUserByEmail(@PathVariable String email);

}
