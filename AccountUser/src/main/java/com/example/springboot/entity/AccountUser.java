package com.example.springboot.entity;

import com.example.springboot.dto.request.CreateAccountRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name ="AccountUser")
@AllArgsConstructor
@NoArgsConstructor
public class AccountUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String fullname;


    public void ConvertAccountUserToCreateAccountRequest (CreateAccountRequest request){
        this.id = request.getId();
        this.username = request.getUsername();
        this.password = request.getPassword();
        this.fullname = request.getFullname();
    }
}
