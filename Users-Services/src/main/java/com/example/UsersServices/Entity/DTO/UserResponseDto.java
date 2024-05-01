package com.example.UsersServices.Entity.DTO;

import com.example.UsersServices.Enum.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
 @Setter
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String genre;
    private String email;
    private String phone;
    private String password;
    private Role role;
}
