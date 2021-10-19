package com.example.springboot.consumer.component;

import com.example.springboot.dto.request.CreateSystemMessage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "bridgicode-queue")
    public void messageListiner(CreateSystemMessage createSystemMessage){
        LOGGER.info("Message receive. {}", createSystemMessage);
    }
}
