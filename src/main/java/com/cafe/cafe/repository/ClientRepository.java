package com.cafe.cafe.repository;

import com.cafe.cafe.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
