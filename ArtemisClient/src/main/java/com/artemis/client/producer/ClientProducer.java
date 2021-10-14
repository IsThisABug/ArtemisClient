package com.artemis.client.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.artemis.client.constants.ApplicationConstants.TOPIC;

@Component
public class ClientProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Scheduled(cron = "0/135 * * * * ?")
    public void publishMessage() {
        jmsTemplate.convertAndSend(TOPIC, "Test message");
        System.out.println("Message sent to " + TOPIC);
    }

}
