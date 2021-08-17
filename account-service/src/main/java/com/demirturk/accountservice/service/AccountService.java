package com.demirturk.accountservice.service;

import com.demirturk.accountservice.entity.Account;
import com.demirturk.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public Account get(String id){
        return accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
    public Account save(Account account){
        return accountRepository.save(account);
    }
    public Account update(String id, Account account){
        Assert.isNull(id, "Id cannot be null.");
        return accountRepository.save(account);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }
}
