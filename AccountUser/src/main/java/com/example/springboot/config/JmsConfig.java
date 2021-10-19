package com.example.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        jmsListenerContainerFactory.setConcurrency("5-10");
        return jmsListenerContainerFactory;
    }

    // note: phần vừa làm là gửi message
    // note: phần còn lại là nhận message
    // vd đăng kí nhận thông tin, khách hàng sẽ nhận đăng kí dựa trên cái message đã gửi
    // lấy dữ liệu convert về dto mình vừa nhận
    // gửi reqeuest từ client: nhận request từ url -> sử lý những bussiness
    // tìm hiểu thêm về activeMQ -> sử dụng nhiều cho sau này
}










