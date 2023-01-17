package com.pepyachka.stepikspringwebserver.service.impl;

import com.pepyachka.stepikspringwebserver.entity.Account;
import com.pepyachka.stepikspringwebserver.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void testCreate() {
        Account account = new Account();
        account.setPassword("Qwerty123!");

        String encodedPassword = "jf2w0jisdlfnweijdf0qjiedsolkfmwepofdjmsd";

        Mockito.doReturn(encodedPassword).when(passwordEncoder)
                .encode(account.getPassword());
        accountService.create(account);

        Mockito.verify(accountRepository).save(account);
        assertEquals(encodedPassword, account.getPassword());
    }
}