package com.example.customer.repo;

import com.example.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface CustomerRepo extends MongoRepository<Customer,Integer> {
}
