package com.ayush.hello.controller;

import com.ayush.hello.dto.Task_manager;
import com.ayush.hello.dto.Userdto;
import com.ayush.hello.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    public Userservice user;

    @GetMapping
    public List<Userdto> fetch(){
        return user.showalluser();
    }
}
