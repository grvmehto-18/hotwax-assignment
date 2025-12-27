package com.hotwax.ass.dto;

import jakarta.validation.constraints.Min;

public record UpdateOrderItemDTO(

    @Min(value = 1, message = "Quantity must be at least 1")
    Integer quantity,

    String status
) {}
