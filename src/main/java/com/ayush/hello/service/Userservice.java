package com.ayush.hello.service;


import com.ayush.hello.dto.Task_manager;
import com.ayush.hello.dto.Userdto;
import com.ayush.hello.repos.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class Userservice {

    @Autowired
    public Userrepo user;

    @Autowired
    public PasswordEncoder passwordencoder=new BCryptPasswordEncoder();

    public void SaveUser(Userdto user1){
        user1.setPassword(passwordencoder.encode(user1.getPassword()));
        user1.setRoles(Arrays.asList("User"));
        user.save(user1);
    }

    public void deleteuser(String username){
        Userdto x= user.findByUsername(username);
        user.deleteByUsername(username);
    }

    public List<Userdto> showalluser(){
        return user.findAll();
    }
    public List<Task_manager> showalltasksofauser(String username){
        Userdto x=  user.findByUsername(username);
        return x.getTasks();
    }

    public Userdto FindByUsername(String username){
        return user.findByUsername(username);
    }
    public void ChangeEntry(String username,Userdto user1){
        Userdto x= user.findByUsername(username);
        if(user1==null) return ;
        x.setUsername(user1.getUsername());
        x.setPassword(user1.getPassword());
        SaveUser(x);
    }

}
