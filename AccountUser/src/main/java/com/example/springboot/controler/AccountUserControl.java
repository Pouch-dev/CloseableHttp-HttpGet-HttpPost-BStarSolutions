package com.example.springboot.controler;

import com.example.springboot.dto.request.CreateSystemMessage;
import com.example.springboot.dto.request.CreateAccountRequest;
import com.example.springboot.entity.AccountUser;
import com.example.springboot.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountUserControl {

    @Autowired
    private AccountUserService userService;
    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AccountUser>> getAll(@RequestBody CreateSystemMessage createSystemMessage){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/created")
    public ResponseEntity<AccountUser> createAccountUser(@Valid @RequestBody CreateAccountRequest user){
        return ResponseEntity.ok().body(userService.save(user));
    }
}









