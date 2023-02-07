package com.example.rabbitmqtechie.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orderstatus {

    private OrderItem order;
    private String status;
    private String message;

}
