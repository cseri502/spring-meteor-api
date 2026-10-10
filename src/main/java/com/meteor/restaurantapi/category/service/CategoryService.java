package com.meteor.restaurantapi.category.service;

import com.meteor.restaurantapi.category.dto.CategoryCreateRequest;
import com.meteor.restaurantapi.category.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(CategoryCreateRequest request);

    List<CategoryResponse> findAll();

    CategoryResponse findById(Long id);
}
