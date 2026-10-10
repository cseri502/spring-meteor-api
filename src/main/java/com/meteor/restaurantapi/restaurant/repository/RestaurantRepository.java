package com.meteor.restaurantapi.restaurant.repository;

import com.meteor.restaurantapi.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
