package com.meteor.restaurantapi.common.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ApiErrorResponse(
        int status,
        String error,
        String message,
        LocalDateTime timestamp,
        List<String> validationErrors
) {
    public static ApiErrorResponse of(int status, String error, String message) {
        return new ApiErrorResponse(status, error, message, LocalDateTime.now(), List.of());
    }

    public static ApiErrorResponse validation(List<String> errors) {
        return new ApiErrorResponse(
                400,
                "Validation failed",
                "One or more fields are invalid",
                LocalDateTime.now(),
                errors
        );
    }
}
