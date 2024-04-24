package com.project.app.rest.Controller;

import com.project.app.rest.Models.User;
import com.project.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {


    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Hello World";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    //localhost:8080/users

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved";
    }
    //localhost:8080/save

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id,@RequestBody User user){
        User updateUser = userRepo.findById(id).get();

        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());
        updateUser.setEmail(user.getEmail());

        userRepo.save(updateUser);
        return "Updated";
    }
    //localhost:8080/update/1
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with ID " + id + " from database";
    }
    //localhost:8080/delete/1

}
