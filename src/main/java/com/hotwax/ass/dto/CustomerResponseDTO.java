package com.hotwax.ass.dto;

import java.util.List;

public record CustomerResponseDTO(
    Integer customerId,
    String firstName,
    String lastName,
    List<ContactMechDTO> contacts
) {}
