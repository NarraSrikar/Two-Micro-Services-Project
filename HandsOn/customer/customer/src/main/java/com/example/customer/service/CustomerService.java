package com.example.customer.service;

import com.example.customer.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {


    Customer deleteById(Integer id);

    List<Customer> getCustomers();

    Customer addCustomer(Customer customer);

    Customer findById(Integer id);

    Optional<Customer> getCustomerById(Integer id);



 //   Customer getDeleteById(Integer id);
}
