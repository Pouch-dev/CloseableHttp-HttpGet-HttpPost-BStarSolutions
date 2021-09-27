package com.example.springboot.controler;

import com.example.springboot.entity.ConsumeAccountUser;
import com.example.springboot.service.consume.ConsumeAccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/consume/account")
public class ConsumeAccountUserControl {

    @Autowired
    ConsumeAccountUserService accountUserService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> callGET() throws IOException {
        return ResponseEntity.ok().body(accountUserService.callGet());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> callPOST(@RequestBody ConsumeAccountUser user) throws IOException{
        return ResponseEntity.ok().body(accountUserService.callPost(user));
    }
}
