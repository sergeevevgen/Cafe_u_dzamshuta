package com.cafe.cafe.repository;

import com.cafe.cafe.model.Chat;
import com.cafe.cafe.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
