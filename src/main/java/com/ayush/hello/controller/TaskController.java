package com.ayush.hello.controller;


import com.ayush.hello.dto.Task_manager;
import com.ayush.hello.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    public Service service;


    @PostMapping
    public boolean addmessage(@RequestBody Task_manager task1){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        service.saveentry(task1,username);
        return true;
    }
    @DeleteMapping("/{myid}")
    public boolean deletemessage(@PathVariable String myid){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        service.deletebyid(myid,username);
        return true;
    }
    @PutMapping("/{myid}")
    public boolean updateMessage(@PathVariable String myid , @RequestBody Task_manager task1){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        service.changeentry(myid,task1,username);
        return true;
    }

}
