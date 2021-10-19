package com.example.springboot.controler;

import com.example.springboot.dto.request.CreateSystemMessage;
import com.example.springboot.entity.SystemMessage;
import com.example.springboot.service.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    @Autowired private JmsTemplate jmsTemplate;
    @Autowired private SystemMessageService messageService;


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/publishMessage")
    public ResponseEntity<SystemMessage> publishMessage(@RequestBody CreateSystemMessage createSystemMessage){
        jmsTemplate.convertAndSend("bridgicode-queue", createSystemMessage);
        return ResponseEntity.ok().body(messageService.save(createSystemMessage));
    }


}
