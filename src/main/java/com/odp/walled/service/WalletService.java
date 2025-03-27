package com.odp.walled.service;

import com.odp.walled.dto.WalletResponse;
import com.odp.walled.exception.ResourceNotFound;
import com.odp.walled.mapper.WalletMapper;
import com.odp.walled.model.User;
import com.odp.walled.model.Wallet;
import com.odp.walled.repository.UserRepository;
import com.odp.walled.repository.WalletRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;
    private final UserRepository userRepository;
    private final WalletMapper walletMapper;

    public WalletResponse createWallet(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("User not found"));
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setAccountNumber(generateUniqueAccountNumber());
        wallet.setBalance(BigDecimal.ZERO);
        return walletMapper.toResponse(walletRepository.save(wallet));
    }

    private String generateUniqueAccountNumber() {
        Random random = new Random();
        String accountNumber;
        do {
            accountNumber = String.format("%020d", Math.abs(random.nextLong())).substring(0, 12);
        } while (walletRepository.existsByAccountNumber(accountNumber));
        return accountNumber;
    }

    public WalletResponse getWalletById(Long id) {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Wallet not found"));
        return walletMapper.toResponse(wallet);
    }
}