package com.artemis.client.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import static com.artemis.client.constants.ApplicationConstants.TOPIC;

@Component
public class ClientConsumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = TOPIC)
    public void consumeMessage(String incomingMessage) {
        System.out.println(incomingMessage);
    }

}
