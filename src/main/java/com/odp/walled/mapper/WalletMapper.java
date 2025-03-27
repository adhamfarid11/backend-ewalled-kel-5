package com.odp.walled.mapper;

import com.odp.walled.dto.WalletResponse;
import com.odp.walled.model.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WalletMapper {
    WalletMapper INSTANCE = 
    Mappers.getMapper(WalletMapper.class);
    @Mapping(source = "user.id", target = "userId")
    WalletResponse toResponse(Wallet wallet);
}