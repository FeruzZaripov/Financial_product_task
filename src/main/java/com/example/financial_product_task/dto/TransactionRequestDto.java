package com.example.financial_product_task.dto;

import java.math.BigDecimal;

public record TransactionRequestDto(
        Long userId,
        BigDecimal amount,
        String description
) {
}
