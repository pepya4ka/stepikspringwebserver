package com.pepyachka.stepikspringwebserver.service.impl;

import com.pepyachka.stepikspringwebserver.entity.Account;
import com.pepyachka.stepikspringwebserver.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("userDetailsService")
@AllArgsConstructor
public class AccountDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Account not found"));

        return new User(
                account.getLogin(),
                account.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }
}
