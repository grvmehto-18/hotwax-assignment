package com.hotwax.ass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotwax.ass.model.OrderItem;

public interface OrderItemRepository
        extends JpaRepository<OrderItem, Integer> {
}
