package com.example.AuthentificationSecurity.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String firstName;
    private String lastName;
    private String password;
    private String genre;
    private String email;
}
