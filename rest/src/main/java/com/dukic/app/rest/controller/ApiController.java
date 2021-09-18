package com.dukic.app.rest.controller;

import com.dukic.app.rest.models.User;
import com.dukic.app.rest.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser (User user){
        userRepository.save(user);
        return "Saved.";
    }

    @PutMapping(value="update/{id}")
    public String updatedUser(@PathVariable long id, @RequestBody User user){
    User updatedUser = userRepository.findById(id).get();
    updatedUser.setFirstName(user.getFirstName());
    updatedUser.setLastName(user.getLastName());
    updatedUser.setOccupation(user.getOccupation());
    updatedUser.setAge(user.getAge());
    userRepository.save(updatedUser);
    return "Updated";
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "deleted";


    }
}
