package com.cafe.cafe.repository;

import com.cafe.cafe.model.Client;
import com.cafe.cafe.model.Combo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComboRepository extends JpaRepository<Combo, Long> {
}
