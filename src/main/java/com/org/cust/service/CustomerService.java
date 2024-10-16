package com.org.cust.service;

import com.org.cust.model.db.CustomerEntity;
import com.org.cust.model.request.CustomerRequest;
import com.org.cust.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<CustomerEntity> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public CustomerEntity createCustomer(CustomerRequest customerRequest) {

        CustomerEntity customer = new CustomerEntity();
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        customer.setAddress(customerRequest.getAddress());

        return customerRepository.save(customer);
    }

    public Optional<CustomerEntity> updateCustomer(Long id, CustomerRequest customerRequest) {
        CustomerEntity updatedCustomer = new CustomerEntity();
        updatedCustomer.setName(customerRequest.getName());
        updatedCustomer.setEmail(customerRequest.getEmail());
        updatedCustomer.setAddress(customerRequest.getAddress());

        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(updatedCustomer.getName());
                    customer.setEmail(updatedCustomer.getEmail());
                    customer.setAddress(updatedCustomer.getAddress());
                    return customerRepository.save(customer);
                });
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
