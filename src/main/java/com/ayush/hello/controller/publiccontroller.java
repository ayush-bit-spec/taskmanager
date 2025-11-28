package com.ayush.hello.controller;

import com.ayush.hello.dto.Userdto;
import com.ayush.hello.service.Userservice;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/public")
@Slf4j
public class publiccontroller {

    @Autowired
    public Userservice user;

//    private static final Logger logger = LoggerFactory.getLogger(publiccontroller.class);

    @PostMapping
    public boolean save(@RequestBody Userdto user1){
        log.info("hello log's");
        log.warn("hello log's");
        log.error("hello log's");
        user.SaveUser(user1);
        return true;
    }
}
