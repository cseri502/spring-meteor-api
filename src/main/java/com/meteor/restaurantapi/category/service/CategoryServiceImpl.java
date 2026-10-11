package com.meteor.restaurantapi.category.service;

import com.meteor.restaurantapi.category.dto.CategoryCreateRequest;
import com.meteor.restaurantapi.category.dto.CategoryResponse;
import com.meteor.restaurantapi.category.entity.Category;
import com.meteor.restaurantapi.category.repository.CategoryRepository;
import com.meteor.restaurantapi.common.exception.ResourceAlreadyExistsException;
import com.meteor.restaurantapi.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public CategoryResponse create(CategoryCreateRequest request) {
        if (categoryRepository.existsByNameIgnoreCase(request.name())) {
            throw new ResourceAlreadyExistsException("Category", "name", request.name());
        }

        Category category = Category.builder()
                .name(request.name())
                .build();

        Category saved = categoryRepository.save(category);

        return toResponse(saved);
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public CategoryResponse findById(Long id) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));

        return toResponse(category);
    }

    private CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }
}
