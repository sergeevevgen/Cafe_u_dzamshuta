package com.cafe.cafe.repository;

import com.cafe.cafe.model.Client;
import com.cafe.cafe.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
