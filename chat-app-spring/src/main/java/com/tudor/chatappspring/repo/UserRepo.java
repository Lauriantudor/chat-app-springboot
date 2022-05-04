package com.tudor.chatappspring.repo;

import com.tudor.chatappspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
    public User findById(int userid);


}
