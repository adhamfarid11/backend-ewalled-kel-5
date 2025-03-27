// src/main/java/com/odp/walled/dto/TransactionDTO.java
package com.odp.walled.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDTO {
    private Long id;
    private Long walletId;
    private String transactionType;
    private BigDecimal amount;
    private Long recipientWalletId;
    private String description;
}