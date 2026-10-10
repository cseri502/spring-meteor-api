package com.meteor.restaurantapi.menu.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MenuItemResponse(
        Long id,

        Long restaurantId,
        String restaurantName,

        Long categoryId,
        String categoryName,

        String name,
        String description,
        BigDecimal price,
        boolean available,

        LocalDateTime createdAt
) {
}
