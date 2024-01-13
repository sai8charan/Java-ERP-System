package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom query to find customers by name
    List<Customer> findByName(String name);

    // Custom query to find customers by email
    Customer findByEmail(String email);

    // Add more custom queries as needed
}
