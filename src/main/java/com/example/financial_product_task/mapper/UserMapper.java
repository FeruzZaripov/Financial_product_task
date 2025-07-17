package com.example.financial_product_task.mapper;

import com.example.financial_product_task.dto.UserRequestDto;
import com.example.financial_product_task.dto.UserResponseDto;
import com.example.financial_product_task.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDto dto);

    @Mapping(target = "id", expression = "java(user.getId())")
    @Mapping(target = "name", expression = "java(user.getName())")
    @Mapping(target = "email", expression = "java(user.getEmail())")
    @Mapping(target = "balance", expression = "java(user.getBalance())")
    @Mapping(target = "createdAt", expression = "java(user.getCreatedAt())")
    UserResponseDto toDto(User user);

}
