package com.example.AuthentificationSecurity.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String genre;
    private String email;
}
