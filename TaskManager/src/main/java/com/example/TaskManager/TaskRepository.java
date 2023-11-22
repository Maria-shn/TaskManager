package com.example.TaskManager;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
  
    List<Task> findByCreator(String creator);
    List<Task> findByTeammate1(String teammate1);
    List<Task> findByTeammate2(String teammate2);
    List<Task> findByTeammate3(String teammate3);
    
}
