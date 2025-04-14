package com.odp.walled.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.odp.walled.dto.LoginRequest;
import com.odp.walled.dto.LoginResponse;
import com.odp.walled.dto.RegisterRequest;
import com.odp.walled.dto.RegisterResponse;
import com.odp.walled.exception.DuplicateException;
import com.odp.walled.exception.ResourceNotFound;
import com.odp.walled.model.User;
import com.odp.walled.repository.UserRepository;
import com.odp.walled.util.JwtUtils;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // Inject PasswordEncoder

    private final WalletService walletService;

    private static JwtUtils jwtUtils;

    public RegisterResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateException("Email already exists");
        }

        // Validate password
        String password = request.getPassword();
        if (password.length() < 8 ||
                !password.matches(".*[a-z].*") ||
                !password.matches(".*[A-Z].*") ||
                !password.matches(".*\\d.*")) {
            throw new IllegalArgumentException(
                    "Password must be at least 8 characters long, contain at least one lowercase letter, one uppercase letter, and one number");
        }

        // Encode the password
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // Encode password
                .fullname(request.getFullname())
                .phoneNumber(request.getPhoneNumber())
                .username(request.getUsername())
                .build();
        userRepository.save(user);

        walletService.createWallet(user.getId());

        return new RegisterResponse(
                "User registered successfully",
                user.getId().toString(),
                user.getEmail());
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFound("User not found"));

        // Verify password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        // Generate JWT token
        String token = jwtUtils.generateToken(user.getEmail());
        return new LoginResponse("Login successful", token);
    }

}
