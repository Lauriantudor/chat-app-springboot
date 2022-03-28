package com.tudor.chatapppspringboot.repo;

import com.tudor.chatapppspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByUserId(String userId);
}
