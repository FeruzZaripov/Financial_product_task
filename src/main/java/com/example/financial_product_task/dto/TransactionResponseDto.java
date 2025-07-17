package com.example.financial_product_task.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponseDto(
        Long id,
        BigDecimal amount,
        String description,
        Long userId,
        LocalDateTime createdAt
) {
}
