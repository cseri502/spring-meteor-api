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
}
