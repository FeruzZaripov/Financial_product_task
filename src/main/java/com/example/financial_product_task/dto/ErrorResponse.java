package com.example.financial_product_task.dto;

public record ErrorResponse(
        String message,
        String error,
        int status
) {
    public static ErrorResponse of(String message, String error, int status) {
        return new ErrorResponse(message, error, status);
    }
}
