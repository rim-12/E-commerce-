package com.example.UsersServices.Entity.DTO;

import com.example.UsersServices.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestDto {
    private Long id;
    private String email;
    private String lastName;
    private String firstName;
    private String genre;
    private String phone;
    private String password;
    private Role role;

}
