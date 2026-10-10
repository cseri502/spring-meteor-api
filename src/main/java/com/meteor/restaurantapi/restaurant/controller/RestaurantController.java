package com.meteor.restaurantapi.restaurant.controller;

import com.meteor.restaurantapi.restaurant.dto.RestaurantCreateRequest;
import com.meteor.restaurantapi.restaurant.dto.RestaurantResponse;
import com.meteor.restaurantapi.restaurant.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantResponse> create(
            @Valid @RequestBody RestaurantCreateRequest request
            ) {

        var response = restaurantService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public List<RestaurantResponse> findAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/{id}")
    public RestaurantResponse findById(@PathVariable Long id) {
        return restaurantService.findById(id);
    }
}
