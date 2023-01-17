package com.pepyachka.stepikspringwebserver.repository;

import com.pepyachka.stepikspringwebserver.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    Optional<Account> findByLogin(String login);
}
