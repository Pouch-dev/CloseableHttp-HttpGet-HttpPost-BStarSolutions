package com.example.springboot.entity.payload;

import com.example.springboot.entity.ConsumeAccountUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CsAccountUser {
//
//    private List<ConsumeAccountUser> accountUserList;


    private Integer id;
    private String username;
    private String password;
    private String fullname;
}
