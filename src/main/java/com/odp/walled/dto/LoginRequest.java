package com.odp.walled.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotEmpty(message = "Email is required")
    private String email;
    @NotEmpty(message = "Password is required")
    private String password;
}
