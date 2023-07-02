package com.foodapp.foodtruck.repository;

import com.foodapp.foodtruck.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {

    @Query("{creatorRut: '?0'}")
    List<Task> getTasksByCreatorRut(String creatorRut);

    Task getTaskById(String id);

    void deleteTaskById(String id);
}
