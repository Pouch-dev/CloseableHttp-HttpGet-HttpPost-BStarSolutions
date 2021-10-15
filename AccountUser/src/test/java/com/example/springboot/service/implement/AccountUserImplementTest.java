package com.example.springboot.service.implement;

import com.example.springboot.dto.response.AccountUserResponse;
import com.example.springboot.entity.AccountUser;
import com.example.springboot.utils.NotificationUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(NotificationUtil.class)
public class AccountUserImplementTest {

    @InjectMocks
    private AccountUserImplement userImplement;

    AccountUser accountUser = new AccountUser(1,"diemphuoc","123","Quach Diem Phuoc");

    @Before
    public void setup ( ){
        initMocks(NotificationUtil.class);
    }

    @Test
    public void createAccount ( ){
        //Given
        int id = 1;
        String username = "diemphuoc";
        String password = "123";
        String fullname = "Quach Diem Phuoc";
        mockStatic(NotificationUtil.class); // Noti.. bean fake
        //When
        when(NotificationUtil.createAccount(id,username,password,fullname)).thenReturn("success");
        //Then
        AccountUserResponse response = userImplement.createAccount(accountUser);
        assertEquals("success",response.getMessage());
    }
}