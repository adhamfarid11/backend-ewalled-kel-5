package com.odp.walled.service;

import com.odp.walled.dto.UserRequest;
import com.odp.walled.dto.UserResponse;
import com.odp.walled.exception.DuplicateException;
import com.odp.walled.exception.ResourceNotFound;
import com.odp.walled.mapper.UserMapper;
import com.odp.walled.model.User;
import com.odp.walled.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(UserRequest request) {
        if (request.getPhoneNumber() != null && 
        userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new DuplicateException("Phone number already in use");
        }
        if (userRepository.existsByEmail(request.getEmail()))
            throw new DuplicateException("Email already exists");

        if (userRepository.existsByUsername(request.getUsername()))
            throw new DuplicateException("Username already exists");
        
        User user = userMapper.toEntity(request);
        return userMapper.toResponse(userRepository.save(user));
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found"));
        return userMapper.toResponse(user);
    }
}