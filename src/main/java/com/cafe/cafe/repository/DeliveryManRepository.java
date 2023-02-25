package com.cafe.cafe.repository;

import com.cafe.cafe.model.Client;
import com.cafe.cafe.model.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Long> {
}
