package com.odp.walled.dto;

import com.odp.walled.model.Transaction.TransactionType;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionResponse {
    private Long id;
    private Long walletId;
    private TransactionType transactionType;
    private BigDecimal amount;
    private Long recipientWalletId;
    private LocalDateTime transactionDate;
    private String description;
}