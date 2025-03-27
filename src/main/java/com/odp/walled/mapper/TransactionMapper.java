package com.odp.walled.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.odp.walled.dto.TransactionResponse;
import com.odp.walled.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionMapper INSTANCE = 
    Mappers.getMapper(TransactionMapper.class);
    
    @Mapping(source = "wallet.id", target = "walletId")
    @Mapping(source = "recipientWallet.id", 
    target = "recipientWalletId")
    TransactionResponse toResponse(Transaction transaction);

}