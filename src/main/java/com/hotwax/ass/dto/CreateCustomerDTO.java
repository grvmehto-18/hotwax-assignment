package com.hotwax.ass.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record CreateCustomerDTO(

    @NotBlank(message = "First name is required")
    String firstName,

    @NotBlank(message = "Last name is required")
    String lastName,

    @NotEmpty(message = "At least one contact is required")
    @Valid
    List<ContactMechDTO> contacts
) {}
