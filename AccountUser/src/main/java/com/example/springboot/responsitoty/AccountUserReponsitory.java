package com.example.springboot.responsitoty;

import com.example.springboot.dto.request.CreateAccountRequest;
import com.example.springboot.entity.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountUserReponsitory extends JpaRepository<AccountUser, Integer> {

    @Query("SELECT o FROM AccountUser o WHERE o.username = ?1")
    Optional<AccountUser> findByAccountUserUsername(String username);
}
