package com.hotwax.ass.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateCustomerDTO(
        @NotBlank String firstName,
        @NotBlank String lastName
) {}

