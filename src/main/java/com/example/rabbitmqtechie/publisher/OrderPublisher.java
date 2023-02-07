package com.example.rabbitmqtechie.publisher;

import com.example.rabbitmqtechie.config.MessagingConfig;
import com.example.rabbitmqtechie.dto.OrderItem;
import com.example.rabbitmqtechie.dto.Orderstatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String placeOrder(@RequestBody OrderItem orderitem, @PathVariable String restaurantName){
        orderitem.setOrderid(UUID.randomUUID().toString());
        //call restaurant service
        //call payment service
        Orderstatus orderstatus = new Orderstatus(orderitem, "IN PROGRESS", "Order Successfully placed "+restaurantName);
        rabbitTemplate.convertAndSend(MessagingConfig.TOPIC_EXCHANGE, MessagingConfig.ROUTING_KEY, orderstatus);
        return "Success! Your order is placed at ->"+restaurantName;
    }
}
