package com.foodapp.foodtruck.services;

import com.foodapp.foodtruck.dto.UserDto;
import com.foodapp.foodtruck.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll() {
        return userRepository.findAll();
    }

    public UserDto getByDni(String dni) {
        return userRepository.findUserByDni(dni);
    }

    public int getCountOfUsersAgeRange(int age1, int age2) {
        return userRepository.getRangeAge(age1, age2);
    }

    public boolean saveUser(UserDto user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println("Error to save user: " + user.getDni() + ", error:" + e);
            return false;
        }
    }

    public boolean deleteBy(UserDto user) {
        String id = getByDni(user.getDni()).getId();
        if (getByDni(user.getDni()) != null) {
            this.userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
