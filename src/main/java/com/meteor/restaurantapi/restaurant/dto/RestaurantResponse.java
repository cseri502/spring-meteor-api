package com.meteor.restaurantapi.restaurant.dto;

import java.time.LocalDateTime;

public record RestaurantResponse(
        Long id,
        String name,
        String description,
        String phone,
        String email,
        LocalDateTime createdAt
) {
}
