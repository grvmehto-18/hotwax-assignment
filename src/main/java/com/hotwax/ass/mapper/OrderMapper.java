package com.hotwax.ass.mapper;

import com.hotwax.ass.dto.OrderCustomerDTO;
import com.hotwax.ass.dto.OrderItemResponseDTO;
import com.hotwax.ass.dto.OrderResponseDTO;
import com.hotwax.ass.exception.ResourceNotFoundException;
import com.hotwax.ass.model.ContactMech;
import com.hotwax.ass.model.OrderHeader;
import com.hotwax.ass.model.OrderItem;

public class OrderMapper {

    private OrderMapper() {
        // prevent instantiation
    }

    public static OrderResponseDTO toDto(OrderHeader order) {

        return new OrderResponseDTO(
                order.getOrderId(),
                order.getOrderDate(),
                new OrderCustomerDTO(
                        order.getCustomer().getCustomerId(),
                        order.getCustomer().getFirstName(),
                        order.getCustomer().getLastName()
                ),
                formatAddress(order.getShippingContact()),
                formatAddress(order.getBillingContact()),
                order.getItems()
                        .stream()
                        .map(OrderMapper::mapItem)
                        .toList()
        );
    }

    private static OrderItemResponseDTO mapItem(OrderItem item) {
        return new OrderItemResponseDTO(
                item.getOrderItemSeqId(),
                item.getProduct().getProductId(),
                item.getProduct().getProductName(),
                item.getQuantity(),
                item.getStatus()
        );
    }

    private static String formatAddress(
            ContactMech c) {

        return c.getStreetAddress() + ", " +
                c.getCity() + ", " +
                c.getState() + " - " +
                c.getPostalCode();
    }



}
