package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create a new customer
    public Customer createCustomer(Customer customer) {
        // Add any additional business logic or validation here
        return customerRepository.save(customer);
    }

    // Retrieve a customer by ID
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.orElse(null);
    }

    // Update an existing customer
    public Customer updateCustomer(Long customerId, Customer customer) {
        // Check if the customer exists
        if (customerRepository.existsById(customerId)) {
            // Update customer details
            customer.setCustomerId(customerId);
            return customerRepository.save(customer);
        }
        return null; // Customer not found
    }

    // Delete a customer by ID
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    // Bulk Load: Import multiple customer records
    public List<Customer> bulkLoadCustomers(List<Customer> customers) {
        // Add any bulk load logic, validation, and save to the database
        return customerRepository.saveAll(customers);
    }

    // Bulk Update: Update multiple records at once
    public List<Customer> bulkUpdateCustomers(List<Customer> customers) {
        // Add any bulk update logic, validation, and save to the database
        return customerRepository.saveAll(customers);
    }
}
