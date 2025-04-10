// src/main/java/com/odp/walled/dto/UserDTO.java
package com.odp.walled.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserWalletDTO {
    private Long id;
    private Long walletId;
    private String email;
    private String username;
    private String fullname;
    private String avatarUrl;
}