package com.meteor.restaurantapi.menu.service;

import com.meteor.restaurantapi.menu.dto.MenuItemCreateRequest;
import com.meteor.restaurantapi.menu.dto.MenuItemResponse;

import java.util.List;

public interface MenuItemService {
    MenuItemResponse create(Long restaurantId, MenuItemCreateRequest request);

    List<MenuItemResponse> findAllByRestaurantId(Long restaurantId);

    MenuItemResponse findById(Long id);

    void delete(Long id);
}
