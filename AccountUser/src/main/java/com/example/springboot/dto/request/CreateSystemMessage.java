package com.example.springboot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSystemMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String source;
    private String message;


}
