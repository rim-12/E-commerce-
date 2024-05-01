package com.example.UsersServices.Service;

import com.example.UsersServices.Entity.DTO.UserRequestDto;
import com.example.UsersServices.Entity.DTO.UserResponseDto;
import com.example.UsersServices.Exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    public UserResponseDto addUser(UserRequestDto userDto);
    public UserResponseDto createUser(UserRequestDto userDto);
    UserResponseDto updateUser(Long id, UserRequestDto userDto) throws UserNotFoundException;
    void deleteUser(Long id) throws UserNotFoundException;
    Object getUserById(Long id) throws UserNotFoundException;

    UserResponseDto getByUserLastName(String username) throws UserNotFoundException;

    UserResponseDto getUserByEmail(String email) throws UserNotFoundException;
}
