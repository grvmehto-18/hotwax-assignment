package com.hotwax.ass.dto;

public record OrderItemResponseDTO(
    Integer orderItemSeqId,
    Integer productId,
    String productName,
    Integer quantity,
    String status
) {}
