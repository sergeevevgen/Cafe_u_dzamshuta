package com.cafe.cafe.repository;

import com.cafe.cafe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByLoginIgnoreCase(String login);
}
