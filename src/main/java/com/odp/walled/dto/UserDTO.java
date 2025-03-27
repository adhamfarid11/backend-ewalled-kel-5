// src/main/java/com/odp/walled/dto/UserDTO.java
package com.odp.walled.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String username;
    private String fullname;
    private String password;
    private String avatarUrl;
}