package com.tudor.chatappspring.controolller;

import com.tudor.chatappspring.model.User;
import com.tudor.chatappspring.repo.UserRepo;
import com.tudor.chatappspring.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserRepo repo;
    @Autowired
    private UserService service;

    @PostMapping("/registeruser")
    @CrossOrigin("http://localhost:4200/")

    public User registerUser(@RequestBody User user) throws Exception{

        String tempEmail = user.getEmail();
        if (tempEmail !=null && !"".equals(tempEmail)){
          User userObj = service.fetchUserByEmail(tempEmail);
          if (userObj != null){
              throw new Exception("User with "+ tempEmail+ "already exist");
          }
        }
        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }
    @PostMapping("/login")
    @CrossOrigin("http://localhost:4200/")
    public User loginUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();

        User userObj =null;
        if (tempEmail != null && tempPassword != null){
            userObj = service.fetchUserByEmailAndPassword(tempEmail,tempPassword);

        }
        if (userObj == null){
            throw new Exception("bade credential");
        }
        return userObj;
    }
    @GetMapping("/users")
    @CrossOrigin("http://localhost:4200/")
    public List<User> getUsers(){
        return service.getUsers();
    }
    @PostMapping("/user/{id}")
    @CrossOrigin("http://localhost:4200")
    public User selectUser(@PathVariable int id){
        User user =service.findUserById(id);
        return user;
    }


}
