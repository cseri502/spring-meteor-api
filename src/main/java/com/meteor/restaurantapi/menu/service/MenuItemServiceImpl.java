package com.meteor.restaurantapi.menu.service;

import com.meteor.restaurantapi.category.repository.CategoryRepository;
import com.meteor.restaurantapi.common.exception.ResourceNotFoundException;
import com.meteor.restaurantapi.menu.dto.MenuItemCreateRequest;
import com.meteor.restaurantapi.menu.dto.MenuItemResponse;
import com.meteor.restaurantapi.menu.entity.MenuItem;
import com.meteor.restaurantapi.menu.repository.MenuItemRepository;
import com.meteor.restaurantapi.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuItemServiceImpl implements MenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public MenuItemResponse create(Long restaurantId, MenuItemCreateRequest request) {
        var restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant", restaurantId));

        var category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Category with id "
                                + request.categoryId()
                                + " not found"
                        ));

        var menuItem = MenuItem.builder()
                .restaurant(restaurant)
                .category(category)
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .available(request.available())
                .build();

        var saved = menuItemRepository.save(menuItem);

        return toResponse(saved);
    }

    @Override
    public List<MenuItemResponse> findAllByRestaurantId(Long restaurantId) {
        if (!restaurantRepository.existsById(restaurantId)) {
            throw new ResourceNotFoundException("Restaurant", restaurantId);
        }

        return menuItemRepository.findAllByRestaurantId(restaurantId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public MenuItemResponse findById(Long id) {
        var menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem", id));

        return toResponse(menuItem);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!menuItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("MenuItem", id);
        }

        menuItemRepository.deleteById(id);
    }

    private MenuItemResponse toResponse(MenuItem menuItem) {

        return new MenuItemResponse(
                menuItem.getId(),
                menuItem.getRestaurant().getId(),
                menuItem.getRestaurant().getName(),
                menuItem.getCategory().getId(),
                menuItem.getCategory().getName(),
                menuItem.getName(),
                menuItem.getDescription(),
                menuItem.getPrice(),
                menuItem.getAvailable(),
                menuItem.getCreatedAt()
        );
    }
}
