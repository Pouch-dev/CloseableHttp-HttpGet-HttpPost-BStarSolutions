package com.example.springboot.service;

import com.example.springboot.dto.request.CreateSystemMessage;
import com.example.springboot.entity.SystemMessage;

import java.util.List;

public interface SystemMessageService {

    SystemMessage save (CreateSystemMessage entity);


    List<SystemMessage> findBySource (String source);
}
