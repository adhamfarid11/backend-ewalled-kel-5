package com.odp.walled.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String email;
    private String username;
    private String fullname;
    private String avatarUrl;
    private String phoneNumber;
}