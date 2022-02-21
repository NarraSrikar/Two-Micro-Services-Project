package com.example.account.service;

import com.example.account.model.Account;
import com.example.account.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepo accountRepo;

    @Override
    public Account addAccount(Account account1) {
        return accountRepo.save(account1);
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return accountRepo.findById(id);
    }

    @Override
    public List<Account> getAccountList() {
       return (List<Account>) accountRepo.findAll();
    }


    @Override
    public List<Account> deleteById(Integer id) {
        accountRepo.deleteById(id);
        return (List<Account>) accountRepo.findAll();
    }

//    @Override
//    public Account updateAccount(Account account2) {
//        return updateAccount(account2);
//    }


}
