package com.hotwax.ass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotwax.ass.model.Customer;

public interface CustomerRepository
        extends JpaRepository<Customer, Integer> {
}
