package com.vinc.service.order.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
    private Integer id;

    private Integer pid;

    private Float price;

    private Integer uid;
}