package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    // Retrieve a customer by ID
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // Update an existing customer
    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customerId, customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    // Delete a customer by ID
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Bulk Load: Import multiple customer records
    @PostMapping("/bulk-load")
    public ResponseEntity<List<Customer>> bulkLoadCustomers(@RequestBody List<Customer> customers) {
        List<Customer> loadedCustomers = customerService.bulkLoadCustomers(customers);
        return new ResponseEntity<>(loadedCustomers, HttpStatus.CREATED);
    }

    // Bulk Update: Update multiple records at once
    @PutMapping("/bulk-update")
    public ResponseEntity<List<Customer>> bulkUpdateCustomers(@RequestBody List<Customer> customers) {
        List<Customer> updatedCustomers = customerService.bulkUpdateCustomers(customers);
        return new ResponseEntity<>(updatedCustomers, HttpStatus.OK);
    }
}
