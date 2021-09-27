package com.example.springboot.service;

import com.example.springboot.entity.AccountUser;
import org.springframework.data.domain.Example;

import java.util.List;

public interface AccountUserService {

    List<AccountUser> findAll();

    AccountUser save(AccountUser entity);

    AccountUser findById(Integer integer);

    void deleteById(Integer integer);
}
