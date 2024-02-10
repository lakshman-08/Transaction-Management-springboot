package com.springboot.TransactionManagementspringboot.service;

import com.springboot.TransactionManagementspringboot.dto.OrderRequest;
import com.springboot.TransactionManagementspringboot.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
