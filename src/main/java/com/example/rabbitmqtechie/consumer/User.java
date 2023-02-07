package com.example.rabbitmqtechie.consumer;

import com.example.rabbitmqtechie.config.MessagingConfig;
import com.example.rabbitmqtechie.dto.Orderstatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Orderstatus orderstatus){
        System.out.println("Message received from Priya Queue "+orderstatus);
    }
}
