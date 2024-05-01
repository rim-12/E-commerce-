package com.example.UsersServices.Controller;

import com.example.UsersServices.Entity.DTO.UserRequestDto;
import com.example.UsersServices.Entity.DTO.UserResponseDto;
import com.example.UsersServices.Exception.UserInputNotValidException;
import com.example.UsersServices.Exception.UserNotFoundException;
import com.example.UsersServices.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<?> getUserById(@PathVariable Long id) throws UserNotFoundException {
        try {
            return new ResponseEntity(this.userService.getUserById(id), HttpStatus.OK);
        } catch (UserNotFoundException var3) {
            return new ResponseEntity("Utilisateur Not Found!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to get user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userDto) {
      try {
          return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
      } catch (UserNotFoundException e){
          return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
      } catch (UserInputNotValidException e) {
          return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
      } catch (Exception e) {
          return new ResponseEntity<>("Failed to update user", HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto userDto) {
        try {
            return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (UserInputNotValidException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            return new ResponseEntity<>("Failed to create user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/email={email}")
    public UserResponseDto findByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User with ID" + id + "deleted succefully");
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            return new ResponseEntity<>("Failed to delete user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


