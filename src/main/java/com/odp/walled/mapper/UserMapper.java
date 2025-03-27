package com.odp.walled.mapper;

import com.odp.walled.dto.UserRequest;
import com.odp.walled.dto.UserResponse;
import com.odp.walled.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = 
    Mappers.getMapper(UserMapper.class);
    
    User toEntity(UserRequest request);
    
    UserResponse toResponse(User user);
}