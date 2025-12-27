package com.hotwax.ass.mapper;

import com.hotwax.ass.dto.ContactMechDTO;
import com.hotwax.ass.dto.CustomerResponseDTO;
import com.hotwax.ass.exception.ResourceNotFoundException;
import com.hotwax.ass.model.ContactMech;
import com.hotwax.ass.model.Customer;
import com.hotwax.ass.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class CustomerMapper {
    private CustomerRepository customerRepo;


    private CustomerMapper() {
    }

    public static CustomerResponseDTO toDto(Customer customer) {

        return new CustomerResponseDTO(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getContacts()
                        .stream()
                        .map(CustomerMapper::mapContact)
                        .toList()
        );
    }

    private static ContactMechDTO mapContact(ContactMech c) {
        return new ContactMechDTO(
                c.getContactMechId(),
                c.getStreetAddress(),
                c.getCity(),
                c.getState(),
                c.getPostalCode(),
                c.getPhoneNumber(),
                c.getEmail()
        );
    }

    public CustomerResponseDTO getCustomer(Integer id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found"));

        return CustomerMapper.toDto(customer); // 👈 HERE
    }

}
