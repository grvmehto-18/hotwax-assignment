package com.hotwax.ass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotwax.ass.model.OrderHeader;

public interface OrderHeaderRepository
        extends JpaRepository<OrderHeader, Integer> {
}
