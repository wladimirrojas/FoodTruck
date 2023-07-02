package com.foodapp.foodtruck.services;

import com.foodapp.foodtruck.model.Task;
import com.foodapp.foodtruck.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTaskByCreatorRut(String creatorRut) {
        return this.taskRepository.getTasksByCreatorRut(creatorRut);
    }

    public boolean saveTask(Task task) {
        try {
            taskRepository.save(task);
            return true;
        } catch (Exception e) {
            System.out.println("Error when saving task for creatorRut: " + task.getCreatorRut() + ", error: " + e);
            return false;
        }
    }

    public boolean deleteTaskById(String id) {

        try {
            if (Objects.nonNull(taskRepository.getTaskById(id))) {
                taskRepository.deleteTaskById(id);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error when deleting task with id: " + id +", error: " + e);
            return false;
        }

    }
}
