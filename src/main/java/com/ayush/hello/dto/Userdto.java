package com.ayush.hello.dto;


import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "userdb")
public class Userdto {

    @Id
    public String id;
    @NonNull
    @Indexed(unique = true)
    public String username ;
    @NonNull
    public String password ;
    @DBRef
    public List<Task_manager> tasks=new ArrayList<>();
    public List<String> Roles=new ArrayList<>();


}
