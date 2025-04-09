package com.odp.walled.controller;

import com.odp.walled.dto.BaseResponse;
import com.odp.walled.dto.TransactionRequest;
import com.odp.walled.dto.TransactionResponse;
import com.odp.walled.dto.TransactionResponseWithUser;
import com.odp.walled.service.TransactionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse createTransaction(@Valid @RequestBody TransactionRequest request) {
        return transactionService.processTransaction(request);
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<TransactionResponseWithUser>>> getTransactionsByWallet(
            @RequestParam Long walletId) {
        return ResponseEntity.ok(new BaseResponse<List<TransactionResponseWithUser>>("Success",
                transactionService.getTransactionsByWallet(walletId)));
    }
}