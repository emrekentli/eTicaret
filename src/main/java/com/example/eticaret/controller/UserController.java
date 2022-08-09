package com.example.eticaret.controller;

import com.example.eticaret.entity.User;
import com.example.eticaret.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/register/{userMail}/{userName}/{password}")
    public User register(@PathVariable (name = "userName") String userName,
                         @PathVariable (name = "password") String password,
                         @PathVariable (name = "userMail") String mail){

        return userService.register(mail,userName,password);
    }

    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable (name = "userId") String userId){

        return userService.getUserByUserId(userId);
    }
    @GetMapping("/login/{mail}/{password}")
    public User login(@PathVariable (name = "mail") String userMail,
                      @PathVariable (name = "password") String password){

      return userService.loginUser(userMail,password);
    }


    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable (name = "userId") String userId){
        userService.deleteUser(userId);
    }


}
