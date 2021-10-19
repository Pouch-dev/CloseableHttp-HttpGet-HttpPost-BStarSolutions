package com.example.springboot.responsitoty;

import com.example.springboot.dto.request.CreateAccountRequest;
import com.example.springboot.entity.AccountUser;
import com.example.springboot.service.AccountUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// TODO: 10/11/2021
@DataJpaTest
class AccountUserReponsitoryTest {

    // TODO: 10/11/2021
//    @Autowired
//    private AccountUserService service;

    @Autowired
    private AccountUserReponsitory userReponsitory;

    //private static final String DATABASE_SQL_SCRIPT = "testdbdata/AccountUser.sql";

    // TODO: 10/11/2021
    @Test
    public void findAll (){
        List<AccountUser> findAllUser = userReponsitory.findAll();
        assertNotNull(findAllUser);
    }

    // TODO: 10/11/2021
    @Test
    public void save (){
        AccountUser account = userReponsitory.save(new AccountUser(1,"diemphuoc 01","123","Quach Diem Phuoc"));
        assertNotNull(account);
        assertTrue(account.getId()>0);
    }

    // TODO: 10/11/2021
    @Test
    public void findById ( ){
        Optional<AccountUser> findByIdUser = userReponsitory.findById(1);
        assertNotNull(findByIdUser);
    }
}