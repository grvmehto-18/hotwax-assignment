package com.hotwax.ass.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactMechDTO(

    Integer contactMechId,   // nullable for CREATE, present for READ

    @NotBlank(message = "Street address is required")
    String streetAddress,

    @NotBlank(message = "City is required")
    String city,

    @NotBlank(message = "State is required")
    String state,

    @NotBlank(message = "Postal code is required")
    String postalCode,

    @Size(max = 20, message = "Phone number too long")
    String phoneNumber,

    @Email(message = "Invalid email format")
    String email
) {}
