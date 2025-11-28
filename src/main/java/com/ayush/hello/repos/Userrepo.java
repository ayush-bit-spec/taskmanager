package com.ayush.hello.repos;

import com.ayush.hello.dto.Userdto;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

public interface Userrepo extends MongoRepository<Userdto,String> {

    Userdto findByUsername(String username);
    void deleteByUsername(String username);
}
