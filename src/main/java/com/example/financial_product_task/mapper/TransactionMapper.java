package com.example.financial_product_task.mapper;

import com.example.financial_product_task.dto.TransactionRequestDto;
import com.example.financial_product_task.dto.TransactionResponseDto;
import com.example.financial_product_task.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction toEntity(TransactionRequestDto dto);

    @Mapping(target = "userId", expression = "java(transaction.getUser().getId())")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "createdAt", source = "createdAt")
    TransactionResponseDto toDto(Transaction transaction);

}
