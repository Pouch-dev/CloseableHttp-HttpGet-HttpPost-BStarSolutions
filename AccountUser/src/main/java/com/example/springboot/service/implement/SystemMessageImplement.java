package com.example.springboot.service.implement;

import com.example.springboot.dto.request.CreateSystemMessage;
import com.example.springboot.entity.AccountUser;
import com.example.springboot.entity.SystemMessage;
import com.example.springboot.exceptions.ApiRequestException;
import com.example.springboot.responsitoty.SystemMessageReponsitory;
import com.example.springboot.service.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SystemMessageImplement implements SystemMessageService {

    @Autowired SystemMessageReponsitory reponsitory;


    @Override
    public SystemMessage save (CreateSystemMessage systemMessage){
        SystemMessage message = new SystemMessage();
        List<SystemMessage> messages = reponsitory.findBySource(systemMessage.getSource());
        if(messages.size()>1){
            throw new ApiRequestException(String.format("Message is exist "+ systemMessage.getSource()));
        }else {
            message.ConvertSystemMessageToCreateSystemMessage(systemMessage);
        }
        return reponsitory.save(message);
    }

    @Override
    public List<SystemMessage> findBySource (String source){
        return reponsitory.findBySource(source);
    }
}
