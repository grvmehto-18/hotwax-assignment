package com.hotwax.ass.service;

import com.hotwax.ass.dto.CreateCustomerDTO;
import com.hotwax.ass.dto.CustomerResponseDTO;
import com.hotwax.ass.dto.UpdateCustomerDTO;
import com.hotwax.ass.exception.ResourceNotFoundException;
import com.hotwax.ass.mapper.CustomerMapper;
import com.hotwax.ass.model.ContactMech;
import com.hotwax.ass.model.Customer;
import com.hotwax.ass.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepo;

    // CREATE
    public Integer create(CreateCustomerDTO dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.firstName());
        customer.setLastName(dto.lastName());

        List<ContactMech> contacts = dto.contacts().stream().map(c -> {
            ContactMech cm = new ContactMech();
            cm.setStreetAddress(c.streetAddress());
            cm.setCity(c.city());
            cm.setState(c.state());
            cm.setPostalCode(c.postalCode());
            cm.setPhoneNumber(c.phoneNumber());
            cm.setEmail(c.email());
            cm.setCustomer(customer);
            return cm;
        }).toList();

        customer.setContacts(contacts);
        return customerRepo.save(customer).getCustomerId();
    }

    // READ
    public CustomerResponseDTO getById(Integer id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        return CustomerMapper.toDto(customer);
    }

    // UPDATE
    public void update(Integer id, UpdateCustomerDTO dto) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        customer.setFirstName(dto.firstName());
        customer.setLastName(dto.lastName());
    }

    // DELETE
    public void delete(Integer id) {
        if (!customerRepo.existsById(id)) {
            throw new ResourceNotFoundException("Customer not found");
        }
        customerRepo.deleteById(id);
    }
}
