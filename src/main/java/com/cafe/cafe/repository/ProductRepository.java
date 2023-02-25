package com.cafe.cafe.repository;

import com.cafe.cafe.model.Client;
import com.cafe.cafe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
