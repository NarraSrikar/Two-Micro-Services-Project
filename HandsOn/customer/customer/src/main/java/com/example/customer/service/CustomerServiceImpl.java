package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepo.findById(id);
    }

    @Override
    public Customer deleteById(Integer id) {
      return customerRepo.findById(id).get();

    }

//    @Override
//    public Customer getDeleteById(Integer id) {
//        return  customerRepo.findById(id).get();
//    }

    @Override
    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepo.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepo.findById(id).get();
    }




}
