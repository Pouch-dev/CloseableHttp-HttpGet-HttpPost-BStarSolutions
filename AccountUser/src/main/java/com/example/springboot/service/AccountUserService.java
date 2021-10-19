package com.example.springboot.service;

import com.example.springboot.dto.request.CreateAccountRequest;
import com.example.springboot.dto.response.AccountUserResponse;
import com.example.springboot.entity.AccountUser;

import java.util.List;
import java.util.Optional;

public interface AccountUserService {

    List<AccountUser> findAll();

    AccountUser save(CreateAccountRequest entity);

    AccountUserResponse createAccount (AccountUser entity);

    AccountUser findById(Integer integer);

    void deleteById(Integer integer);

    AccountUser findByAccountUserUsername (AccountUser username);
}
