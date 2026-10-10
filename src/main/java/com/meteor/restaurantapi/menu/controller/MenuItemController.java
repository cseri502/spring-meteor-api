package com.meteor.restaurantapi.menu.controller;

import com.meteor.restaurantapi.menu.dto.MenuItemCreateRequest;
import com.meteor.restaurantapi.menu.dto.MenuItemResponse;
import com.meteor.restaurantapi.menu.service.MenuItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuItemController {
    private final MenuItemService menuItemService;

    @PostMapping("/restaurants/{restaurantId}/menu-items")
    public ResponseEntity<MenuItemResponse> create(
            @PathVariable Long restaurantId,
            @Valid @RequestBody MenuItemCreateRequest request
            ) {

        var response = menuItemService.create(restaurantId, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/restaurants/{restaurantId}/menu-items")
    public List<MenuItemResponse> findAllByRestaurant(@PathVariable Long restaurantId) {
        return menuItemService.findAllByRestaurantId(restaurantId);
    }

    @GetMapping("/menu-items/{id}")
    public MenuItemResponse findById(@PathVariable Long id) {
        return menuItemService.findById(id);
    }

    @DeleteMapping("/menu-items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        menuItemService.delete(id);
    }
}
