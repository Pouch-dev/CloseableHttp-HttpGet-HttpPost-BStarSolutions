package com.example.springboot.service;

import com.example.springboot.dto.request.OrderRequest;
import com.example.springboot.dto.response.OrderResponse;
import com.example.springboot.utils.NotificationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public OrderResponse checkoutOrder(OrderRequest order) {
        // call DAO
        int discount= addDiscount(order);//1000
        order.setPrice(order.getPrice()-discount);//10000-1000=9000
        String message = NotificationUtil.sendEmail(order.getEmailId());
        return new OrderResponse(order, message, HttpStatus.OK.value());
    }

    private int addDiscount(OrderRequest order) {//1000
        System.out.println("called...");
        int price = order.getPrice();//10000
        int discountAMount = 0;
        if (order.isDiscountable()) {// == true
            if (order.getPrice() > 1000) {// 10000 > 1000
                discountAMount = price * 10 / 100; //10000 * 10 / 100 = 1000
            } else {
                discountAMount = price; //10000
            }
        } else {// == false
            discountAMount = price; //10000
        }
        return discountAMount; //1000
    }
}
