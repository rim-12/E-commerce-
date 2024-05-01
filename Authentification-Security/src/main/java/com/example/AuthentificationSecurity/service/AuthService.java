package com.example.AuthentificationSecurity.service;

import com.example.AuthentificationSecurity.Exc.WrongCredentialsException;
import com.example.AuthentificationSecurity.Request.LoginRequest;
import com.example.AuthentificationSecurity.Request.RegisterRequest;
import com.example.AuthentificationSecurity.client.UserServiceClient;
import com.example.AuthentificationSecurity.dto.RegisterDto;
import com.example.AuthentificationSecurity.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserServiceClient userServiceClient;
    private final JwtService jwtService;


    public TokenDto login(LoginRequest request) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        if (authenticate.isAuthenticated())
            return TokenDto
                    .builder()
                    .token(jwtService.generateToken(request.getEmail()))
                    .build();
        else throw new WrongCredentialsException("Wrong credentials");
    }

    public RegisterDto register(RegisterRequest request) {
        return userServiceClient.save(request).getBody();
    }
}
