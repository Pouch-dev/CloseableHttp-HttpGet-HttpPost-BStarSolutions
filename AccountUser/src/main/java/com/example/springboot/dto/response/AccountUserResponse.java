package com.example.springboot.dto.response;

import com.example.springboot.dto.request.OrderRequest;
import com.example.springboot.entity.AccountUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountUserResponse {
    private AccountUser response;
    private String message;
    private int statusCode;

}
