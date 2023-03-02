package com.cafe.cafe.repository;

import com.cafe.cafe.model.Order;
import com.cafe.cafe.model.Order_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_ItemRepository extends JpaRepository<Order_Item, Long> {
}
