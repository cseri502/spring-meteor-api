package com.meteor.restaurantapi.restaurant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RestaurantCreateRequest(
        @NotBlank(message = "Name is required")
        String name,

        String description,

        @NotBlank(message = "Phone is required")
        String phone,

        @Email(message = "Email must be valid")
        String email
) {
}
