package com.meteor.restaurantapi.restaurant.service;

import com.meteor.restaurantapi.common.exception.ResourceNotFoundException;
import com.meteor.restaurantapi.restaurant.dto.RestaurantCreateRequest;
import com.meteor.restaurantapi.restaurant.dto.RestaurantResponse;
import com.meteor.restaurantapi.restaurant.entity.Restaurant;
import com.meteor.restaurantapi.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public RestaurantResponse create(RestaurantCreateRequest request) {
        Restaurant restaurant = Restaurant.builder()
                .name(request.name())
                .description(request.description())
                .phone(request.phone())
                .email(request.email())
                .build();

        Restaurant saved = restaurantRepository.save(restaurant);

        return toResponse(saved);
    }

    @Override
    public List<RestaurantResponse> findAll() {
        return restaurantRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public RestaurantResponse findById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant", id));

        return toResponse(restaurant);
    }

    private RestaurantResponse toResponse(Restaurant restaurant) {
        return new RestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getPhone(),
                restaurant.getEmail(),
                restaurant.getCreatedAt()
        );
    }
}
