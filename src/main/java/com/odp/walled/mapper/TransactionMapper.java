package com.odp.walled.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.odp.walled.dto.TransactionResponse;
import com.odp.walled.dto.TransactionResponseWithUser;
import com.odp.walled.dto.UserWalletDTO;
import com.odp.walled.model.Transaction;
import com.odp.walled.model.User;
import com.odp.walled.model.Wallet;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source = "wallet.id", target = "walletId")
    @Mapping(source = "recipientWallet.id", target = "recipientWalletId")
    TransactionResponse toResponse(Transaction transaction);

    @Mapping(target = "sender", expression = "java(mapUser(transaction.getWallet().getUser(), transaction.getWallet()))")
    @Mapping(target = "recipient", expression = "java(transaction.getRecipientWallet() != null ? mapUser(transaction.getRecipientWallet().getUser(), transaction.getRecipientWallet()) : null)")
    TransactionResponseWithUser toResponseWithUser(Transaction transaction);

    default UserWalletDTO mapUser(User user, Wallet wallet) {
        if (user == null || wallet == null)
            return null;

        return UserWalletDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .fullname(user.getFullname())
                .avatarUrl(user.getAvatarUrl())
                .walletId(wallet.getId())
                .build();
    }
}