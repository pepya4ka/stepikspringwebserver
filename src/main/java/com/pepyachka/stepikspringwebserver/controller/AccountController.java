package com.pepyachka.stepikspringwebserver.controller;

import com.pepyachka.stepikspringwebserver.entity.Account;
import com.pepyachka.stepikspringwebserver.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/accounts/signup")
    public Account create(@RequestBody Account account) {
        return accountService.create(account);
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/me")
    public Account getCurrentAccount() {
        return accountService.getCurrentAccount();
    }
}
