package com.example.springboot.responsitoty;

import com.example.springboot.entity.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserReponsitory extends JpaRepository<AccountUser, Integer> {


    Object getAll ( );
}
