package com.cafe.cafe.repository;

import com.cafe.cafe.model.Client;
import com.cafe.cafe.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
