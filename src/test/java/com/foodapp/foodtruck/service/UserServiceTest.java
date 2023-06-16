package com.foodapp.foodtruck.service;

import com.foodapp.foodtruck.dto.UserDto;
import com.foodapp.foodtruck.repository.UserRepository;
import com.foodapp.foodtruck.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {


    private UserRepository repository;

    private UserService service;

    @BeforeEach
    public void setup() {
        this.repository = mock(UserRepository.class);
        service = new UserService(repository);
    }

    @Test
    void findAll_whenGetAllUsers_thenReturnUsers() {
        //Arrange
        List<UserDto> usersList = List.of(new UserDto(), new UserDto());

        //Act
        when(repository.findAll()).thenReturn(usersList);
        List<UserDto> response = service.findAll();

        //Assert
        assertTrue(!response.isEmpty());
    }

    @Test
    void getByDni_whenGetUserByDni_thenReponseUser() {
        //Arrange
        UserDto user = new UserDto("id123", "name", 20, "13.333.333-3");

        //Act
        when(repository.findUserByDni(anyString())).thenReturn(user);
        UserDto response = service.getByDni("id123");

        //Assert
        assertNotNull(response);
        assertTrue(!response.getName().isEmpty());
    }




}
