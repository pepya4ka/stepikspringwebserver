package com.pepyachka.stepikspringwebserver.service;

import com.pepyachka.stepikspringwebserver.entity.Account;

public interface AccountService {
    Account create(Account account);
    Iterable<Account> getAllAccounts();
    Account getCurrentAccount();

}
