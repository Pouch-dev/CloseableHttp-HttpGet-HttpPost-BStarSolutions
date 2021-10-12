package com.example.springboot.service.implement;

import com.example.springboot.entity.AccountUser;
import com.example.springboot.responsitoty.AccountUserReponsitory;
import com.example.springboot.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserImplement implements AccountUserService {

    @Autowired
    AccountUserReponsitory userReponsitory;

    @Override
    public List<AccountUser> findAll() {
        return userReponsitory.findAll();
    }

    @Override
    public AccountUser save(AccountUser entity) {
        return userReponsitory.save(entity);
    }

    @Override
    public AccountUser findById(Integer integer) {
        return userReponsitory.findById(integer).get();
    }

    @Override
    public void deleteById(Integer integer) {
        userReponsitory.deleteById(integer);
    }
}
