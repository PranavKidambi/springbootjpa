package com.springnew.service;

import com.springnew.dto.UserRequestDto;
import com.springnew.dto.UserResponseDto;
import com.springnew.dto.UserUpdateDto;
import com.springnew.entity.Address;
import com.springnew.entity.User;
import com.springnew.exception.ResourceNotFoundException;
import com.springnew.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public UserService(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    public UserResponseDto createUser(UserRequestDto dto) {
        User user = modelMapper.map(dto, User.class);
        return modelMapper.map(userRepo.save(user), UserResponseDto.class);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepo.findAll().stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
    }

    public UserResponseDto getUserById(int id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));
        return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto getUserByName(String name) {
        User user = userRepo.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("User with name " + name + " not found"));
        return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto getUserByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));
        return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto getUserByPhone(String phone) {
        User user = userRepo.findByPhone(phone)
                .orElseThrow(() -> new ResourceNotFoundException("User with phone " + phone + " not found"));
        return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto getUserBySalary(double salary) {
        User user = userRepo.findBySalary(salary)
                .orElseThrow(() -> new ResourceNotFoundException("User with salary " + salary + " not found"));
        return modelMapper.map(user, UserResponseDto.class);
    }

    public List<UserResponseDto> getUsersByActive(boolean active) {
        return userRepo.findUsersByActive(active).stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
    }

    public UserResponseDto getBirthday(LocalDate birthday) {
        User user = userRepo.findByBirthday(birthday)
                .orElseThrow(() -> new ResourceNotFoundException("Birthday " + birthday + " not found"));
        return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto updateUser(int id, UserUpdateDto dto) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));

        modelMapper.map(dto, user);

        if (dto.getAddress() != null) {
            Address address = user.getAddress() != null ? user.getAddress() : new Address();
            modelMapper.map(dto.getAddress(), address);
            user.setAddress(address);
        }

        return modelMapper.map(userRepo.save(user), UserResponseDto.class);
    }

    public UserResponseDto patchUser(int id, UserUpdateDto dto) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));

        if (dto.getName() != null) user.setName(dto.getName());
        if (dto.getEmail() != null) user.setEmail(dto.getEmail());
        if (dto.getPhone() != null) user.setPhone(dto.getPhone());
        if (dto.getSalary() != null) user.setSalary(dto.getSalary());
        if (dto.getBirthday() != null) user.setBirthday(dto.getBirthday());

        if (dto.getAddress() != null) {
            Address address = user.getAddress() != null ? user.getAddress() : new Address();
            modelMapper.map(dto.getAddress(), address);
            user.setAddress(address);
        }

        return modelMapper.map(userRepo.save(user), UserResponseDto.class);
    }

    public boolean deleteUser(int id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));
        userRepo.delete(user);
        return true;
    }
}
