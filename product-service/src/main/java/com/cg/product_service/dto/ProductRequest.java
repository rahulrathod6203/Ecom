package com.cg.product_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(

        @NotBlank(message = "Product name cannot be blank!")
        String name,

        @NotNull(message = "Price is required!")
        @Positive(message = "Price must be greater than 0!")
        Long price,

        @NotNull(message = "Quantity is required!")
        @Positive(message = "Quantity must be greater than 0!")
        Long quantity
) {
}
