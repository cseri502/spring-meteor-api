package com.meteor.restaurantapi.menu.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record MenuItemCreateRequest(
        @NotNull Long categoryId,
        @NotBlank String name,
        String description,
        @NotNull @DecimalMin(value = "0.01") BigDecimal price,
        boolean available
) {
}
