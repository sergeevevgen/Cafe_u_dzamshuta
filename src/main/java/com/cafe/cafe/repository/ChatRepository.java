package com.cafe.cafe.repository;

import com.cafe.cafe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Category, Long> {
}
