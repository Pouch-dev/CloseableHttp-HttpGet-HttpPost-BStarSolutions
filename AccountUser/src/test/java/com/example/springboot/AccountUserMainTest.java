package com.example.springboot;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

// TODO: 10/12/2021
@AutoConfigureMockMvc
@SpringBootTest(classes = AccountUserMain.class)
@ExtendWith(SpringExtension.class)
public class AccountUserMainTest {

    @Autowired
    public MockMvc mockMvc;
}