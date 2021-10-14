package com.artemis.client.config;


import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;


@Configuration
@EnableJms
public class ArtemisConfig {



    @Bean
    public ActiveMQConnectionFactory artemisConnectionFactory() {
        ActiveMQConnectionFactory artemisConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        artemisConnectionFactory.setUser("user");
        artemisConnectionFactory.setPassword("password");
        return artemisConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(artemisConnectionFactory());
        jmsTemplate.setExplicitQosEnabled(true);
        //setting PuSubDomain to true configures JmsTemplate to work with topics instead of queues
        jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(artemisConnectionFactory());
        //setting PuSubDomain to true configures the DefaultJmsListenerContainerFactory to work with topics instead of queues
        factory.setPubSubDomain(true);
        return factory;
    }
}
