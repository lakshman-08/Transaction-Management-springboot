package com.springboot.TransactionManagementspringboot.repository;

import com.springboot.TransactionManagementspringboot.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
