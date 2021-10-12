package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableScheduling
public class AccountUserMain {

    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(AccountUserMain.class, args);
    }
}
