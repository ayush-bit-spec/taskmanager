package com.ayush.hello.service;

import com.ayush.hello.dto.Task_manager;
import com.ayush.hello.dto.Userdto;
import com.ayush.hello.repos.TaskManagaerRepository;
import com.ayush.hello.repos.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Service {

    @Autowired
    public TaskManagaerRepository taskManagaerRepository;

    @Autowired
    public Userservice user;

    @Autowired
    public Userrepo userrepo;

    public void saveentry(Task_manager tskmng, String username){
        Userdto x=user.FindByUsername(username);
        Task_manager saved=taskManagaerRepository.save(tskmng);
        x.getTasks().add(saved);
        userrepo.save(x);

    }
    public boolean deletebyid(String id, String username){
        Userdto x=user.FindByUsername(username);
        if(x.getTasks().stream().filter(y->y.getId().equals(id)).findFirst().orElse(null)!=null){
            x.getTasks().removeIf(y->y.getId().equals(id));
            taskManagaerRepository.deleteById(id);
            userrepo.save(x);
            return true;
        }
        return false;

    }
    public void changeentry(String id, Task_manager task, String username){
        Userdto x=user.FindByUsername(username);
        Task_manager tsk=x.getTasks().stream().filter(y->y.getId().equals(id)).findFirst().orElse(null);
        assert tsk != null;
        tsk.setName(task.getName());
        tsk.setContent(task.getContent());
        tsk.setDate(LocalDateTime.now());
        taskManagaerRepository.save(tsk);
        userrepo.save(x);
    }


}
