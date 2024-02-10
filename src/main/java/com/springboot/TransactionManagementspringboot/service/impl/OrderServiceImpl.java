package com.springboot.TransactionManagementspringboot.service.impl;

import com.springboot.TransactionManagementspringboot.dto.OrderRequest;
import com.springboot.TransactionManagementspringboot.dto.OrderResponse;
import com.springboot.TransactionManagementspringboot.entity.Order;
import com.springboot.TransactionManagementspringboot.entity.Payment;
import com.springboot.TransactionManagementspringboot.exception.PaymentException;
import com.springboot.TransactionManagementspringboot.repository.OrderRepository;
import com.springboot.TransactionManagementspringboot.repository.PaymentRepository;
import com.springboot.TransactionManagementspringboot.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        //to save the order details
        Order order=orderRequest.getOrder();
        order.setStatus("In Progress");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment=orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }

        //to save the payment details
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        //response for the client to asked request
        OrderResponse orderResponse=new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
