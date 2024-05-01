package com.example.UsersServices.Utilis;

import com.example.UsersServices.Entity.User;
import com.example.UsersServices.Entity.DTO.UserRequestDto;
import com.example.UsersServices.Entity.DTO.UserResponseDto;
import org.modelmapper.ModelMapper;

public class MappingProfile {
    private static final ModelMapper modelMapper = new ModelMapper();
    public static User mapToUserEntity(UserRequestDto userDto) { return modelMapper.map(userDto, User.class);}
    public static UserResponseDto mapToUserDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }
}
