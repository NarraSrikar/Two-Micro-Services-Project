package com.example.account.controller;

import com.example.account.exception.AccountNotFoundException;
import com.example.account.model.Account;
import com.example.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/addAccount")
    public ResponseEntity<Account> addAccount(@Valid @RequestBody Account account1){
        Account addAccountObj= accountService.addAccount(account1);
        return  new ResponseEntity<Account>(addAccountObj,HttpStatus.CREATED);
    }

    @GetMapping("/id/{accountId}")
    public ResponseEntity<Optional<Account>> getAccountById(@PathVariable("accountId")Integer id){
        Optional<Account> optionalAccountObj= accountService.findById(id);
        if(!optionalAccountObj.isPresent()) {
            throw new AccountNotFoundException("No such ID found in the accounts table");
        }
        return  new ResponseEntity<Optional<Account>>(optionalAccountObj,HttpStatus.OK);
    }

//    @GetMapping("/id/{customerId}")
//    public ResponseEntity <List<Account>> getCustomerById(@PathVariable("customerId") Integer id)  {
//        List<Account> a = accountService.getCustomerById(id);
//        if(a.isEmpty()){
//            throw new EmptyInputException("500","input fields are empty");
//        }
//        return new ResponseEntity<>(a, HttpStatus.OK);
//    }

    @GetMapping("/getAccountList")
    public ResponseEntity<List<Account>> getAccountList(){
        List<Account> accountList= accountService.getAccountList();
        return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
    }


//    @PutMapping("/update/{id}")
//    public ResponseEntity<Account> updateAccount(@Valid @RequestBody Account account2){
//        Account addAccountObj= accountService.updateAccount(account2);
//        return  new ResponseEntity<Account>(addAccountObj,HttpStatus.CREATED);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Account>> deleteAccount(@PathVariable Integer id) {
        List<Account> deleteAccount = null;
            Optional<Account> account3 = accountService.findById(id);
            if (account3.isPresent()) {
                deleteAccount=accountService.deleteById(id);
            }
            return new ResponseEntity<List<Account>>(deleteAccount, HttpStatus.OK);
        }
    }

