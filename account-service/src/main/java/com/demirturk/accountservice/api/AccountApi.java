package com.demirturk.accountservice.api;

import com.demirturk.accountservice.entity.Account;
import com.demirturk.accountservice.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("account")
@Slf4j
@Api(value = "account", tags = { "Account APIs" })
public class AccountApi {
    private final AccountService accountService;

    @ApiOperation(value = "Get account by id", response = Account.class)
    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable String id){
        log.info(String.format("AccountApi get started for %s id",id));
        return ResponseEntity.ok(accountService.get(id));
    }

    @ApiOperation(value = "Save account", response = Account.class)
    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @ApiOperation(value = "Update account", response = Account.class)
    @PutMapping
    public ResponseEntity<Account> update(@PathVariable("id") String id,@RequestBody Account account){
        return ResponseEntity.ok(accountService.update(id,account));
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll(){
        return ResponseEntity.ok(accountService.findAll());
    }
}

