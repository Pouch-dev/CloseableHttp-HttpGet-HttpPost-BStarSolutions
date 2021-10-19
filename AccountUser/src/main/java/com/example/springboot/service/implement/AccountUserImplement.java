package com.example.springboot.service.implement;

import com.example.springboot.dto.request.CreateAccountRequest;
import com.example.springboot.dto.response.AccountUserResponse;
import com.example.springboot.entity.AccountUser;
import com.example.springboot.exceptions.ApiRequestException;
import com.example.springboot.responsitoty.AccountUserReponsitory;
import com.example.springboot.service.AccountUserService;
import com.example.springboot.utils.NotificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountUserImplement implements AccountUserService {

    @Autowired
    AccountUserReponsitory userReponsitory;

    @Override
    public List<AccountUser> findAll() {

        return userReponsitory.findAll();
    }

    @Override
    public AccountUser save(CreateAccountRequest accountRequest) {
        AccountUser accountUser = new AccountUser();
        userReponsitory.findById(accountRequest.getId()).orElseThrow(() ->
                new ApiRequestException(String.format("Not found Account with id = [%d]", accountRequest.getId()))
        );
        accountUser.ConvertAccountUserToCreateAccountRequest(accountRequest);
        return userReponsitory.save(accountUser);
    }

    @Override
    public AccountUserResponse createAccount(AccountUser entity) {
//        AccountUser response = new AccountUser();
//        response = userReponsitory.findById(entity.getId()).orElseThrow(() ->
//                new ApiRequestException(String.format("Not found in Account id = [%d]",entity.getId()))
//        );
        String message = NotificationUtil.createAccount(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getFullname());
        return new AccountUserResponse(entity, message, HttpStatus.OK.value());
    }

    @Override
    public AccountUser findById(Integer integer) {
        return userReponsitory.findById(integer).orElseThrow(() ->
                new ApiRequestException(String.format("Not found Account with id = [%d]", integer))
                );
    }

    @Override
    public void deleteById(Integer integer) {
        userReponsitory.findById(integer).orElseThrow(()->
                new ApiRequestException(String.format("Not found Account with id = [%d]", integer))
        );
        userReponsitory.deleteById(integer);
    }

    @Override
    public AccountUser findByAccountUserUsername (AccountUser username){
        AccountUser user = new AccountUser();
        return userReponsitory.findByAccountUserUsername(username.getUsername()).orElseThrow(()->
                new ApiRequestException(String.format("can no found Account by id = [%d]", user.getUsername()))
        );
    }

}
