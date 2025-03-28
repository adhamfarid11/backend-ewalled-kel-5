package com.odp.walled.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String email;
    private String username;
    private String fullname;
    private String avatarUrl;
    private String phoneNumber;
}