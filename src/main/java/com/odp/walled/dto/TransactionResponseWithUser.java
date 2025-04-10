package com.odp.walled.dto;

import com.odp.walled.model.Transaction.TransactionType;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionResponseWithUser {
    private Long id;
    private UserWalletDTO sender;
    private TransactionType transactionType;
    private BigDecimal amount;
    private UserWalletDTO recipient;
    private LocalDateTime transactionDate;
    private String description;
}