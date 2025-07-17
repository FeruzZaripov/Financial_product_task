package com.example.financial_product_task.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UserResponseDto(
        Long id,
        String name,
        String email,
        BigDecimal balance,
        LocalDateTime createdAt
) {
}
