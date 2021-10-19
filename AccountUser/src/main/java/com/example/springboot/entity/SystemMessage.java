package com.example.springboot.entity;

import com.example.springboot.dto.request.CreateAccountRequest;
import com.example.springboot.dto.request.CreateSystemMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SystemMessage")
public class SystemMessage implements Serializable {

    private final static Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String source;
    private String message;

    public void ConvertSystemMessageToCreateSystemMessage (CreateSystemMessage request){
        this.source = request.getSource();
        this.message = request.getMessage();
    }
}
