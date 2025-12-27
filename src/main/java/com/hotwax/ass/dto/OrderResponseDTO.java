package com.hotwax.ass.dto;

import java.time.LocalDate;
import java.util.List;

public record OrderResponseDTO(
    Integer orderId,
    LocalDate orderDate,
    OrderCustomerDTO customer,
    String shippingAddress,
    String billingAddress,
    List<OrderItemResponseDTO> items
) {}
