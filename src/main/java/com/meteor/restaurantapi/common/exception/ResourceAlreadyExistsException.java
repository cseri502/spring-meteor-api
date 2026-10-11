package com.meteor.restaurantapi.common.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String resource, String field, String value) {
        super("%s with %s '%s' already exists".formatted(resource, field, value));
    }
}
