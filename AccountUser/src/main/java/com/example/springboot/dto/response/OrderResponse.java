package com.example.springboot.dto.response;

import com.example.springboot.dto.request.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderResponse {
    private OrderRequest response;
    private String message;
    private int statusCode;

}
