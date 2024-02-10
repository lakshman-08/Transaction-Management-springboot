package com.springboot.TransactionManagementspringboot.dto;

import com.springboot.TransactionManagementspringboot.entity.Order;
import com.springboot.TransactionManagementspringboot.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
