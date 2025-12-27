package com.hotwax.ass.controller;

import com.hotwax.ass.dto.CreateOrderRequestDTO;
import com.hotwax.ass.dto.OrderItemRequestDTO;
import com.hotwax.ass.dto.OrderResponseDTO;
import com.hotwax.ass.dto.UpdateOrderItemDTO;
import com.hotwax.ass.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity<Integer> create(
            @Valid @RequestBody CreateOrderRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createOrder(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOrder(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable Integer id,
            @RequestParam Integer shippingContactId,
            @RequestParam Integer billingContactId) {
        service.updateOrder(id, shippingContactId, billingContactId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{orderId}/items")
    public ResponseEntity<Void> addItem(
            @PathVariable Integer orderId,
            @Valid @RequestBody OrderItemRequestDTO dto) {
        service.addItem(orderId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{orderId}/items/{itemId}")
    public ResponseEntity<Void> updateItem(
            @PathVariable Integer itemId,
            @Valid @RequestBody UpdateOrderItemDTO dto) {
        service.updateItem(itemId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{orderId}/items/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer itemId) {
        service.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }
}
