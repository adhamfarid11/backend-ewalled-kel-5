package com.odp.walled.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class RegisterRequest {
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Full Name is required")
    private String fullname;
    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;
    @NotBlank(message = "Username is required")
    private String username;
}
