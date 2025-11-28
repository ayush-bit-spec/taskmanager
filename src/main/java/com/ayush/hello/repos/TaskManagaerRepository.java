package com.ayush.hello.repos;

import com.ayush.hello.dto.Task_manager;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskManagaerRepository extends MongoRepository<Task_manager,String> {

}
