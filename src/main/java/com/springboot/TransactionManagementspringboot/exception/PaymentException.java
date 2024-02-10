package com.springboot.TransactionManagementspringboot.exception;

public class PaymentException extends RuntimeException{
    public PaymentException(String message)
    {
        super(message);
    }
}
