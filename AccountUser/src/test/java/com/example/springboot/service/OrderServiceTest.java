package com.example.springboot.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doReturn;

import com.example.springboot.dto.request.OrderRequest;
import com.example.springboot.dto.response.OrderResponse;
import com.example.springboot.utils.NotificationUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({NotificationUtil.class, OrderService.class})//Note: insert class test  //  tiet kiem bo nho cho he thong
//@PrepareForTest(fullyQualifiedNames = "com.example.springboot.*")// Note: khong tiet kiem bo nho cho he thong
public class OrderServiceTest {

    // TODO: 10/14/2021
    @InjectMocks
    private OrderService service;

    OrderRequest request = new OrderRequest(111, "Mobile", 1, 10000, "phuoc@gmail.com", true);

    @Before
    public void init() {
        MockitoAnnotations.initMocks(NotificationUtil.class);
    }

    @Test
    public void testStaticMethod() {
        // Given
        String emailid = "phuoc@gmail.com";
        PowerMockito.mockStatic(NotificationUtil.class);//Noti.. bean fake
        when(NotificationUtil.sendEmail(emailid)).thenReturn("success"); // when emailid give of method sendEmail -> return "success"
        // When
        OrderResponse response = service.checkoutOrder(request); // response method checkoutOrder
        // Then -> near assert
        assertEquals("success", response.getMessage()); // then return "success" and equals expected
    }

    //Note : mock is a fake bean
    // spy is a 1/2 real, 1/2 fake bean

    @Test
    public void testPrivateMethod() throws Exception {
        //spy is a 1/2 real, 1/2 fake
        // Given
        OrderService spy = PowerMockito.spy(service);// note: can call real method service
        doReturn(1000).when(spy,"addDiscount",any());// note present call fake bean
        // When
        OrderResponse response = spy.checkoutOrder(request);
        int price = response.getResponse().getPrice();// 9000
        System.out.println("price: " + price);
        //Then
        assertEquals(9000, price);
    }
}