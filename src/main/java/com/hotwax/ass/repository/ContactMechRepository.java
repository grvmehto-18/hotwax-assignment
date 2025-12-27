package com.hotwax.ass.repository;

import com.hotwax.ass.model.ContactMech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMechRepository
        extends JpaRepository<ContactMech, Integer> {
}
