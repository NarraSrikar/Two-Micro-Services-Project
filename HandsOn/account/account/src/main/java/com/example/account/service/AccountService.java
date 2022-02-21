package com.example.account.service;

import com.example.account.model.Account;
import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> getAccountList();

    Account addAccount(Account account1);

    Optional<Account> findById(Integer id);

    List<Account> deleteById(Integer id);


//    Account updateAccount(Account account2);
}
