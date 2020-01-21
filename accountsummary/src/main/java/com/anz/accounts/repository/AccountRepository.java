package com.anz.accounts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anz.accounts.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
