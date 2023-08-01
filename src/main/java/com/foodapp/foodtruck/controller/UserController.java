package com.foodapp.foodtruck.controller;

import com.foodapp.foodtruck.dto.UserDto;
import com.foodapp.foodtruck.model.Task;
import com.foodapp.foodtruck.services.TaskService;
import com.foodapp.foodtruck.services.UserService;
import com.foodapp.foodtruck.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    //private final UserMapper mapper = new UserMapper();

    @Autowired
    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll()
                .stream()
                .map(user -> {
                    if (user.getName().equals("Wladimir")) {
                        String decryptedDni = null;
                        try {
                            decryptedDni = EncryptionUtils.decrypt(user.getDni());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        user.setDni(decryptedDni);
                    }
                    return user;
                })
                .collect(Collectors.toList()));
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody() UserDto userDto) throws Exception {
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestBody() UserDto user) {
        return ResponseEntity.ok(userService.deleteBy(user));
    }

    @PostMapping("/task/save")
    public ResponseEntity<Boolean> saveTask(@RequestBody() Task task) {
        task.setCreationDate(LocalDateTime.now());
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @GetMapping("/task/list/{creatorRut}")
    public ResponseEntity<List<Task>> getTaskByCreatorRut(@PathVariable("creatorRut") String creatorRut) {
        return ResponseEntity.ok(taskService.getTaskByCreatorRut(creatorRut));
    }

    @DeleteMapping("/task/delete/{id}")
    public ResponseEntity<Boolean> deleteTaskById(@PathVariable("id") String id) {
        return ResponseEntity.ok(taskService.deleteTaskById(id));
    }

}
