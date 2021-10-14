package com.artemis.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan({"com.artemis.client"})
public class ClientApplication {

    public static void main(String[] args) { SpringApplication.run(ClientApplication.class, args); }

}
