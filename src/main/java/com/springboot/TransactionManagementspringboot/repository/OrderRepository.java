package com.springboot.TransactionManagementspringboot.repository;

import com.springboot.TransactionManagementspringboot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
