package com.ayush.hello.dto;

//import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "Task_Managerdb")
@Data
public class Task_manager {
    @Id
    public String id;
    public String Name;
    public String Content;
    public LocalDateTime date;
    public int y;
}
