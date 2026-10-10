package com.meteor.restaurantapi.restaurant.service;

import com.meteor.restaurantapi.restaurant.dto.RestaurantCreateRequest;
import com.meteor.restaurantapi.restaurant.dto.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    RestaurantResponse create(RestaurantCreateRequest request);

    List<RestaurantResponse> findAll();

    RestaurantResponse findById(Long id);
}
