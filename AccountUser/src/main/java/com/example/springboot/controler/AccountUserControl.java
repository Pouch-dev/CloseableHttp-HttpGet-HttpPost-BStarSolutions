package com.example.springboot.controler;

import com.example.springboot.entity.AccountUser;
import com.example.springboot.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountUserControl {

    @Autowired
    AccountUserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<AccountUser>> getAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/created")
    public ResponseEntity<AccountUser> createAccountUser(@RequestBody AccountUser user){
        return ResponseEntity.ok().body(userService.save(user));
    }
}
