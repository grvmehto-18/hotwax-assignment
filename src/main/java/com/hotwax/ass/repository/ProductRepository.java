package com.hotwax.ass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotwax.ass.model.Product;

public interface ProductRepository
        extends JpaRepository<Product, Integer> {
}
