package com.odp.walled.controller;

import com.odp.walled.dto.BaseResponse;
import com.odp.walled.dto.WalletResponse;
import com.odp.walled.dto.WalletResponseWithUser;
import com.odp.walled.service.WalletService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public WalletResponse createWallet(@PathVariable Long userId) {
        return walletService.createWallet(userId);
    }

    @GetMapping("/{id}")
    public WalletResponse getWalletById(@PathVariable Long id) {
        return walletService.getWalletById(id);
    }
    
    @GetMapping("/availability/{id}")
    public ResponseEntity<BaseResponse<List<WalletResponseWithUser>>> getWalletTransferAvailability(@PathVariable Long id) {
        List<WalletResponseWithUser> response = walletService.getWalletTransferAvailability(id);
        return ResponseEntity.ok(new BaseResponse<List<WalletResponseWithUser>>("Success", response));
    }

    // @GetMapping("/me")
    // public WalletResponse getMyWallets() {
    // return walletService.getMyWallets();
    // }
}