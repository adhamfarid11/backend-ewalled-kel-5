package com.odp.walled.repository;

import com.odp.walled.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByAccountNumber(String accountNumber);
    
    boolean existsByAccountNumber(String accountNumber);
    
    List<Wallet> findAllByUserId(Long userId);
    
    @Query("SELECT w FROM Wallet w JOIN FETCH w.user WHERE w.id <> :id")
    List<Wallet> findAllByIdNot(Long id);
}