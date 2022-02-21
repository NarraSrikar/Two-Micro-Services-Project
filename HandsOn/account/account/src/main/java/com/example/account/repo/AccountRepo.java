package com.example.account.repo;

import com.example.account.model.Account;
import org.springframework.data.repository.CrudRepository;


public interface AccountRepo extends CrudRepository<Account,Integer> {
}
