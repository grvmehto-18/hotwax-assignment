package com.hotwax.ass.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CreateOrderRequestDTO(

    @NotNull(message = "Order date is required")
    LocalDate orderDate,

    @NotNull(message = "Customer ID is required")
    Integer customerId,

    @NotNull(message = "Shipping contact ID is required")
    Integer shippingContactMechId,

    @NotNull(message = "Billing contact ID is required")
    Integer billingContactMechId,

    @NotEmpty(message = "Order must have at least one item")
    @Valid
    List<OrderItemRequestDTO> orderItems
) {}
