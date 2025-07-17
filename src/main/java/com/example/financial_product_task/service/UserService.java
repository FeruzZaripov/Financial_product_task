package com.example.financial_product_task.service;

import com.example.financial_product_task.dto.UserRequestDto;
import com.example.financial_product_task.dto.UserResponseDto;
import com.example.financial_product_task.mapper.UserMapper;
import com.example.financial_product_task.model.User;
import com.example.financial_product_task.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto createUser(UserRequestDto dto) {
        User user = userMapper.toEntity(dto);
        user.setBalance(BigDecimal.ZERO);
        return userMapper.toDto(userRepository.save(user));
    }

    public UserResponseDto updateUser(Long id, UserRequestDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setName(dto.name());
        user.setEmail(dto.email());
        return userMapper.toDto(userRepository.save(user));
    }

    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toDto(user);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

}
