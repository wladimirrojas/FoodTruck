package com.foodapp.foodtruck.controller;

import com.foodapp.foodtruck.dto.UserDto;
import com.foodapp.foodtruck.mappers.UserMapper;
import com.foodapp.foodtruck.model.User;
import com.foodapp.foodtruck.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserMapper mapper;

    @Autowired
    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll().stream()
                .map(mapper::dtoToModel).toList());
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody() UserDto userDto) {
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestBody() UserDto user) {
        return ResponseEntity.ok(userService.deleteBy(user));
    }
}
