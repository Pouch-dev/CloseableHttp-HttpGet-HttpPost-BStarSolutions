package com.example.springboot.responsitoty;

import com.example.springboot.entity.AccountUser;
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
    @Autowired
    private AccountUserReponsitory reponsitory;

    //private static final String DATABASE_SQL_SCRIPT = "testdbdata/AccountUser.sql";

    // TODO: 10/11/2021
    @Test
    public void findAll (){
        List<AccountUser> findAllUser = reponsitory.findAll();
        assertNotNull(findAllUser);
    }

    // TODO: 10/11/2021
    @Test
    public void save (){
        AccountUser account = reponsitory.save(new AccountUser(1,"DiemPhuoc 0","123","Quach Diem Phuoc"));
        assertNotNull(account);
        assertTrue(account.getId()>0);
    }

    // TODO: 10/11/2021
    @Test
    public void findById ( ){
        Optional<AccountUser> findByIdUser = reponsitory.findById(1);
        assertNotNull(findByIdUser);
    }
}