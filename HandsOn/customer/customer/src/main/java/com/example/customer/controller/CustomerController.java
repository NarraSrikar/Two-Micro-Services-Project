package com.example.customer.controller;

import com.example.customer.exception.CustomerNotActiveException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.feign.AccountFeignClient;
import com.example.customer.model.Account;
import com.example.customer.model.Customer;
import com.example.customer.model.RequireResponse;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    AccountFeignClient accountFeignClient;

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer (@RequestBody Customer customer1){
        Customer  addCustomerObj=customerService.addCustomer(customer1);
        return new ResponseEntity<Customer>(addCustomerObj,HttpStatus.CREATED);
    }

    @GetMapping("/id/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable("customerId")Integer id){
        Optional<Customer> CustomerObj= customerService.getCustomerById(id);
        if(!CustomerObj.isPresent()) {
            throw new CustomerNotFoundException("No such ID found in the customers table");
        }
        return  new ResponseEntity<>(CustomerObj,HttpStatus.OK);
    }

    @GetMapping("/getList")
    public ResponseEntity<List<Customer>> getList(){
        List<Customer> ls=customerService.getCustomers();
        return  new ResponseEntity<List <Customer>>(ls , HttpStatus.OK);
    }

    @GetMapping("/id/CusAccIds/{id}")
    public ResponseEntity<RequireResponse> getAllDataBasedOnCentreId(@PathVariable("id") Integer id){
        RequireResponse requiredResponse=new RequireResponse();
        Customer cus= customerService.findById(id);
        requiredResponse.setCustomer_model(cus);

        Account accounts=accountFeignClient.getId(id);
       requiredResponse.setAccount_model((Account) accounts);
        return new ResponseEntity<RequireResponse>(requiredResponse,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Customer> deleteById(@PathVariable("customerId")Integer id) {
        Customer customerObj = customerService.deleteById(id);
        if (customerObj.getActive()) {
            throw new CustomerNotActiveException("ID is not active in the customers table");
        }
        return  new ResponseEntity<>(customerObj,HttpStatus.OK);
    }
    }
//    @DeleteMapping("/delete/{customerId}")
//    public ResponseEntity<Optional<Customer>> deleteById(@PathVariable("customerId")Integer id){
//        Optional<Customer> customerObj= customerService.deleteById(id);
//        if(!customerObj.isPresent()) {
//            throw new CustomerNotActiveException("ID is not active in the customers table");
//        }
//        return  new ResponseEntity<>(customerObj,HttpStatus.OK);
//    }

