package com.org.cust.service;

import com.org.cust.model.db.CustomerEntity;
import com.org.cust.model.request.CustomerRequest;
import com.org.cust.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCustomerById() {
        CustomerEntity customer = new CustomerEntity();
        customer.setId(1L);
        customer.setName("John Doe");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        Optional<CustomerEntity> foundCustomer = customerService.getCustomerById(1L);
        assertTrue(foundCustomer.isPresent());
        assertEquals("John Doe", foundCustomer.get().getName());
    }

    @Test
    void testCreateCustomer() {
        CustomerRequest customer = new CustomerRequest();
        customer.setName("John Doe");

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName("John Doe");

        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);

        CustomerEntity createdCustomer = customerService.createCustomer(customer);
        assertEquals("John Doe", createdCustomer.getName());
        verify(customerRepository, times(1)).save(customerEntity);
    }
}
