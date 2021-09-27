package com.example.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name ="ConsumeAccountUserService")
@AllArgsConstructor
@NoArgsConstructor
public class ConsumeAccountUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String username;
    private String password;
    private String fullname;

}
