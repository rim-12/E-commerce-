package com.example.UsersServices.Service;

import com.example.UsersServices.Entity.DTO.UserRequestDto;
import com.example.UsersServices.Entity.DTO.UserResponseDto;
import com.example.UsersServices.Enum.ExceptionMessage;
import com.example.UsersServices.Enum.Role;
import com.example.UsersServices.Exception.UserInputNotValidException;
import com.example.UsersServices.Exception.UserNotFoundException;
import com.example.UsersServices.RegistrationValidatorClient.Validator;
import com.example.UsersServices.Repository.UserRepository;
import com.example.UsersServices.Utilis.MappingProfile;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll²().stream()
                .map(MappingProfile::mapToUserDto).toList();
    }

    @Override
    public Object getUserById(Long id) throws UserNotFoundException {
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(ExceptionMessage.USER_NOT_FOUND.getMessage()));
        return new Object() {
            public Long id = user.getId();
            public String fullName = user.getLastName().toUpperCase() + " , " + user.getFirstName();
            public String email = user.getEmail();
            public String genre = user.getGenre();
            public String phone = user.getPhone();
            public String password = user.getPassword();
        };
    }

    @Override
    public UserResponseDto addUser(UserRequestDto userDto) {
        String errorMessage =
                Validator.InputValidatorRegister.isValidEmail(userDto.getEmail()) ? null : ExceptionMessage.EMAIL_IS_INVALID.getMessage();
        errorMessage = errorMessage != null ? errorMessage :
                Validator.InputValidatorRegister.isNull(userDto.getFirstName()) ? ExceptionMessage.FIRSTNAME_IS_REQUIRED.getMessage() : null;
        errorMessage = errorMessage != null ? errorMessage :
                Validator.InputValidatorRegister.isNull(userDto.getLastName()) ? ExceptionMessage.LASTNAME_IS_REQUIRED.getMessage() : null;
        errorMessage = errorMessage != null ? errorMessage :
                userRepository.existsByEmail(userDto.getEmail()) ? ExceptionMessage.EMAIL_ALREADY_EXIST.getMessage() : null;

        if (errorMessage != null) {
            throw new UserInputNotValidException(errorMessage);
        }
        var user = MappingProfile.mapToUserEntity(userDto);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return MappingProfile.mapToUserDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userDto) throws UserNotFoundException {
        String errorMessage =
                Validator.InputValidatorRegister.isNull(userDto.getPassword()) ? null : ExceptionMessage.PASSWORD_LENGTH_ERROR.getMessage();
        errorMessage = errorMessage != null ? errorMessage :
                Validator.InputValidatorRegister.isValidMoroccanPhoneNumber(userDto.getPhone()) ? null : ExceptionMessage.PHONE_NUMBER_NOT_VALID.getMessage();
        errorMessage = errorMessage != null ? errorMessage :
                Validator.InputValidatorRegister.isValidEmail(userDto.getEmail()) ? null : ExceptionMessage.EMAIL_IS_INVALID.getMessage();
        errorMessage = errorMessage != null ? errorMessage :
                Validator.InputValidatorRegister.isNull(userDto.getFirstName()) ? ExceptionMessage.FIRSTNAME_IS_REQUIRED.getMessage() : null;
        errorMessage = errorMessage != null ? errorMessage :
                Validator.InputValidatorRegister.isNull(userDto.getLastName()) ? ExceptionMessage.LASTNAME_IS_REQUIRED.getMessage() : null;
        errorMessage = errorMessage != null ? errorMessage :
                userRepository.existsByEmail(userDto.getEmail()) ? ExceptionMessage.EMAIL_ALREADY_EXIST.getMessage() : null;

        if (errorMessage != null) {
            throw new UserInputNotValidException(errorMessage);
        }
        userDto.setId(id);
        var user = MappingProfile.mapToUserEntity(userDto);
        return MappingProfile.mapToUserDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userDto) throws UserInputNotValidException {
        String errorMessage =
                Validator.InputValidatorRegister.isNull(userDto.getPassword()) ? null : ExceptionMessage.PASSWORD_LENGTH_ERROR.getMessage();
        errorMessage = errorMessage != null ? errorMessage :
                Validator.InputValidatorRegister.isValidMoroccanPhoneNumber(userDto.getPhone()) ? null : ExceptionMessage.PHONE_NUMBER_NOT_VALID.getMessage();
        errorMessage = errorMessage != null ? errorMessage :
                Validator.InputValidatorRegister.isValidEmail(userDto.getEmail()) ? null : ExceptionMessage.EMAIL_IS_INVALID.getMessage();
        errorMessage = errorMessage != null ? errorMessage :
                Validator.InputValidatorRegister.isNull(userDto.getFirstName()) ? ExceptionMessage.FIRSTNAME_IS_REQUIRED.getMessage() : null;
        errorMessage = errorMessage != null ? errorMessage :
                Validator.InputValidatorRegister.isNull(userDto.getLastName()) ? ExceptionMessage.LASTNAME_IS_REQUIRED.getMessage() : null;
        errorMessage = errorMessage != null ? errorMessage :
                userRepository.existsByEmail(userDto.getEmail()) ? ExceptionMessage.EMAIL_ALREADY_EXIST.getMessage() : null;

        if (errorMessage != null) {
            throw new UserInputNotValidException(errorMessage);
        }
        var user = MappingProfile.mapToUserEntity(userDto);
        return MappingProfile.mapToUserDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDto getByUserLastName(String username) throws UserNotFoundException {
        var user = userRepository.findByLastName(username).orElseThrow();
        return MappingProfile.mapToUserDto(user);
    }

    @Override
    public UserResponseDto getUserByEmail(String email) throws UserNotFoundException {
        var user = userRepository.findByEmail(email).orElseThrow();
        return MappingProfile.mapToUserDto(user);
    }

}