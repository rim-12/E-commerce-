package com.example.AuthentificationSecurity.dto;

import com.example.AuthentificationSecurity.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data @Component
@AllArgsConstructor @NoArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private Role role;
}
