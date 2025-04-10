package com.odp.walled.dto;

import com.odp.walled.model.Transaction.TransactionType;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class TransactionRequest {
    @NotNull
    private Long walletId;
    @NotNull
    private TransactionType transactionType;
    @DecimalMin("0.01")
    @NotNull
    private BigDecimal amount;
    @NotNull
    private String recipientAccountNumber;

    private String category;

    private String description;
}