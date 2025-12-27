package com.hotwax.ass.controller;

import com.hotwax.ass.dto.ApiResponse;
import com.hotwax.ass.dto.CreateCustomerDTO;
import com.hotwax.ass.dto.CustomerResponseDTO;
import com.hotwax.ass.dto.UpdateCustomerDTO;
import com.hotwax.ass.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public ResponseEntity<ApiResponse<Integer>> create(
            @Valid @RequestBody CreateCustomerDTO dto) {

        Integer customerId = service.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Customer created successfully",
                        customerId,
                        LocalDateTime.now()
                ));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> get(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Customer fetched successfully",
                        service.getById(id),
                        LocalDateTime.now()
                )
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> update(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateCustomerDTO dto) {

        service.update(id, dto);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Customer updated successfully",
                        null,
                        LocalDateTime.now()
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable Integer id) {

        service.delete(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Customer deleted successfully",
                        null,
                        LocalDateTime.now()
                )
        );
    }

}


