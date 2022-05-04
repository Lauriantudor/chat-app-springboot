package com.tudor.chatappspring.sevice;

import com.tudor.chatappspring.model.User;
import com.tudor.chatappspring.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
        @Autowired
        private UserRepo repo;
        public User saveUser(User user){

            return repo.save(user);
        }
        public List<User> getUsers(){
             return repo.findAll();
        }
        public User fetchUserByEmail(String email){
           return repo.findByEmail(email);
        }
        public User fetchUserByEmailAndPassword(String email, String password){
           return repo.findByEmailAndPassword(email, password);
        }

    public User findUserById(int userid) {
            return repo.findById(userid);
    }
}
