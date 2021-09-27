package com.example.springboot.service.implement;

import com.example.springboot.entity.AccountUser;
import com.example.springboot.responsitoty.AccountUserResponsitory;
import com.example.springboot.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserImplement implements AccountUserService {

    @Autowired
    AccountUserResponsitory userResponsitory;

    @Override
    public List<AccountUser> findAll() {
        return userResponsitory.findAll();
    }

    @Override
    public AccountUser save(AccountUser entity) {
        return userResponsitory.save(entity);
    }

    @Override
    public AccountUser findById(Integer integer) {
        return userResponsitory.findById(integer).get();
    }

    @Override
    public void deleteById(Integer integer) {
        userResponsitory.deleteById(integer);
    }
}
