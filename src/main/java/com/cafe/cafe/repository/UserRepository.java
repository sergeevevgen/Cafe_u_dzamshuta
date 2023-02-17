package com.cafe.cafe.repository;

import com.cafe.cafe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByLoginIgnoreCase(String login);
}
