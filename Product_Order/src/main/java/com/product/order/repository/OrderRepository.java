package com.product.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
