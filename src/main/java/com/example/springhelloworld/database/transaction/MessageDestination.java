package com.example.springhelloworld.database.transaction;

import org.slf4j.*;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageDestination {
    private static Logger LOGGER = LoggerFactory.getLogger(MessageDestination.class);

    @JmsListener(destination = "singers")
    public void onMessage(String message){
        LOGGER.info("--> Received message: " + message);
    }
}