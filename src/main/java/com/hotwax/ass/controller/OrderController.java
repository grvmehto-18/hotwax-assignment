package com.hotwax.ass.controller;

import com.hotwax.ass.dto.*;
import com.hotwax.ass.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    // ================= CREATE ORDER =================
    @PostMapping
    public ResponseEntity<ApiResponse<Integer>> create(
            @Valid @RequestBody CreateOrderRequestDTO dto) {

        Integer orderId = service.createOrder(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Order created successfully",
                        orderId,
                        LocalDateTime.now()
                ));
    }

    // ================= GET ORDER =================
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderResponseDTO>> get(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Order fetched successfully",
                        service.getOrder(id),
                        LocalDateTime.now()
                )
        );
    }

    // ================= UPDATE ORDER =================
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> update(
            @PathVariable Integer id,
            @RequestParam Integer shippingContactId,
            @RequestParam Integer billingContactId) {

        service.updateOrder(id, shippingContactId, billingContactId);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Order updated successfully",
                        null,
                        LocalDateTime.now()
                )
        );
    }

    // ================= DELETE ORDER =================
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {

        service.deleteOrder(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Order deleted successfully",
                        null,
                        LocalDateTime.now()
                )
        );
    }

    // ================= ADD ORDER ITEM =================
    @PostMapping("/{orderId}/items")
    public ResponseEntity<ApiResponse<Void>> addItem(
            @PathVariable Integer orderId,
            @Valid @RequestBody OrderItemRequestDTO dto) {

        service.addItem(orderId, dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Order item added successfully",
                        null,
                        LocalDateTime.now()
                ));
    }

    // ================= UPDATE ORDER ITEM =================
    @PutMapping("/{orderId}/items/{itemId}")
    public ResponseEntity<ApiResponse<Void>> updateItem(
            @PathVariable Integer itemId,
            @Valid @RequestBody UpdateOrderItemDTO dto) {

        service.updateItem(itemId, dto);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Order item updated successfully",
                        null,
                        LocalDateTime.now()
                )
        );
    }

    // ================= DELETE ORDER ITEM =================
    @DeleteMapping("/{orderId}/items/{itemId}")
    public ResponseEntity<ApiResponse<Void>> deleteItem(
            @PathVariable Integer itemId) {

        service.deleteItem(itemId);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Order item deleted successfully",
                        null,
                        LocalDateTime.now()
                )
        );
    }
}
