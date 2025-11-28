package com.ayush.hello.controller;

import com.ayush.hello.dto.Task_manager;
import com.ayush.hello.dto.Userdto;
import com.ayush.hello.service.Userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RestController
@RequestMapping("/user")
public class usercontroller {

    @Autowired
    public Userservice user;



    @GetMapping
    public List<Task_manager> fetchtask(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username1 = authentication.getName();
        return user.showalltasksofauser(username1);
    }



    @DeleteMapping
    public boolean delete(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username1 = authentication.getName();
        user.deleteuser(username1);
        return true;
    }

    @PostMapping
    public boolean post(@RequestBody Userdto user1){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        user.ChangeEntry(username, user1);
        return true;
    }
}
