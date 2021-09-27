package com.example.springboot.service.implement;

import com.example.springboot.entity.ConsumeAccountUser;
import com.example.springboot.responsitoty.AccountUserResponsitory;
import com.example.springboot.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserImplement implements AccountUserService {

    @Autowired AccountUserResponsitory responsitory;


    @Override
    public List<ConsumeAccountUser> findAll() {
        return responsitory.findAll();
    }

    @Override
    public List<ConsumeAccountUser> findAll(Example<ConsumeAccountUser> example) {
        return responsitory.findAll(example);
    }

    @Override
    public ConsumeAccountUser save(ConsumeAccountUser entity) {
        return responsitory.save(entity);
    }

    public List<ConsumeAccountUser> saveAll(Iterable<ConsumeAccountUser> entities) {
        return responsitory.saveAll(entities);
    }
}
