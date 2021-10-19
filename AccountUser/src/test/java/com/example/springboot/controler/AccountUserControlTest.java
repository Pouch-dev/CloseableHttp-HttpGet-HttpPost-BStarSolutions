package com.example.springboot.controler;


import com.example.springboot.AccountUserMainTest;
import com.example.springboot.common.Utils;
import com.example.springboot.dto.request.CreateAccountRequest;
import com.example.springboot.entity.AccountUser;
import com.example.springboot.responsitoty.AccountUserReponsitory;
import com.example.springboot.service.AccountUserService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO: 10/12/2021
class AccountUserControlTest extends AccountUserMainTest {

    @MockBean
    private AccountUserService userService;

    @MockBean
    AccountUserReponsitory userReponsitory;

    // TODO: 10/12/2021
    @Test
//    @WithMockUser(username = "admin", roles = "ADMIN")
    public void testAuthen() throws Exception{
        String requestJson = "{}";
        mockMvc.perform(post("/api/account")
                .content(requestJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    // TODO: 10/12/2021  
    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    public void testGetAll () throws Exception{

        List<AccountUser> list = new ArrayList<>();
        list.add(new AccountUser(1,"DiemPhuoc01","123","Quach Diem Phuoc"));
        list.add(new AccountUser(2,"DiemPhuoc02","123","Quach Diem Phuoc"));
        when(userService.findAll()).thenReturn(list);// create method fake findAll

        Gson gson = new Gson();
        String json = gson.toJson(list);

        String requestJson = Utils.getJsonStringFromFile("testapidata/ListAccountUser.json");
        String mvcResult = mockMvc.perform(get("/account")
                    .content(requestJson)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().is(200))
                    .andReturn().getResponse().getContentAsString();
        assertTrue(mvcResult.contains(json));
        System.out.println(json);
    }

    // TODO: 10/12/2021  
    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    public void testCreateAccountUser () throws Exception{
        AccountUser mockData = new AccountUser(6, "Diem phuoc 01", "123", "Quach Diem Phuoc");
        when(userService.save(any(CreateAccountRequest.class))).thenReturn(mockData);

        // TODO: 10/13/2021 
        Gson gson = new Gson();
        String json = gson.toJson(mockData);

        // TODO: 10/13/2021
        String URL = "/account/created";
        String requestJson = Utils.getJsonStringFromFile("testapidata/AccountUser.json");
        String mvcResult = mockMvc.perform(post(URL)
                .content(requestJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();


        // TODO: 10/13/2021
            assertTrue(mvcResult.contains(json));
        System.out.println(json);

    }
}