package com.springnew.controller;

import com.springnew.dto.UserRequestDto;
import com.springnew.dto.UserResponseDto;
import com.springnew.dto.UserUpdateDto;
import com.springnew.entity.User;
import com.springnew.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;
@Tag(name="User APIs", description="Operations related to user")
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
@Operation(summary = "Register a new user")
    @PostMapping
    public UserResponseDto registerUser(@Valid @RequestBody UserRequestDto userDto){
        return userService.createUser(userDto);
    }
    @Operation(summary = "Get all users")
    @GetMapping
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @Operation(summary="Get use by ID")
    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @Operation(summary="Get user by Email")
    @GetMapping("/email/{email}")
    public UserResponseDto getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @Operation(summary="Get user by birthday")
    @GetMapping("/birthday/{birthday}")
    public UserResponseDto getBirthday(@PathVariable LocalDate birthday){
        return userService.getBirthday(birthday);
    }

    @Operation(summary="Get user by Phone")
    @GetMapping("/phone/{phone}")
    public UserResponseDto getUserByPhone(@PathVariable String phone){
        return userService.getUserByPhone(phone);
    }

    @Operation(summary="Get user by Salary")
    @GetMapping("/salary/{salary}")
    public UserResponseDto getUserBySalary(@PathVariable Double salary){
        return userService.getUserBySalary(salary);
    }

    @Operation(summary="Get user by name")
    @GetMapping("/name/{name}")
    public UserResponseDto getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @Operation(summary="Get users by Active")
    @GetMapping("/active/{active}")
    public List<UserResponseDto> getUserByActive(@PathVariable boolean active){
        return userService.getUsersByActive(active);
    }

    @Operation(summary="Update users details")
    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable int id,@Valid @RequestBody UserUpdateDto dto){
        return userService.updateUser(id, dto);
    }

    @Operation(summary="Patch users details")
    @PatchMapping("/{id}")
    public UserResponseDto patchUser(@PathVariable int id, @RequestBody UserUpdateDto dto){
        return userService.patchUser(id, dto);
    }

    @Operation(summary="Delete User")
    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }



}
