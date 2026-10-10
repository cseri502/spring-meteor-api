package com.meteor.restaurantapi.menu.repository;

import com.meteor.restaurantapi.menu.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findAllByRestaurantId(Long restaurantId);
}
