package com.meteor.restaurantapi.category.repository;

import com.meteor.restaurantapi.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
