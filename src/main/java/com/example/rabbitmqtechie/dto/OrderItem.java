package com.example.rabbitmqtechie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private String orderid;
    private String ordername;
    private int quantity;
    private double price;
}
