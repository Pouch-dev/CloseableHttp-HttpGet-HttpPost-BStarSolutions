package com.example.springboot.service;

import com.example.springboot.entity.ConsumeAccountUser;
import org.springframework.data.domain.Example;

import java.util.List;

public interface AccountUserService {
    List<ConsumeAccountUser> findAll();

    List<ConsumeAccountUser> findAll(Example<ConsumeAccountUser> example);

    ConsumeAccountUser save(ConsumeAccountUser entity);

    List<ConsumeAccountUser> saveAll(Iterable<ConsumeAccountUser> entities);
}
