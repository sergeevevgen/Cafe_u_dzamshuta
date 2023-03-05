package com.cafe.cafe.repository;

import com.cafe.cafe.model.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Long> {
}
