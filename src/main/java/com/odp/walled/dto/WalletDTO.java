// src/main/java/com/odp/walled/dto/WalletDTO.java
package com.odp.walled.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private Long userId;
}