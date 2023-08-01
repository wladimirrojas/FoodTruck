package com.foodapp.foodtruck.services;

import com.foodapp.foodtruck.dto.UserDto;
import com.foodapp.foodtruck.repository.UserRepository;
import com.foodapp.foodtruck.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public boolean saveUser(UserDto user) throws Exception {
        String userDni = EncryptionUtils.encrypt(user.getDni());
        try {
            user.setDni(userDni);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println("Error to save user: " + user.getDni() + ", error:" + e);
            return false;
        }
    }

    public boolean deleteBy(UserDto user) {
        String id = getByDni(user.getDni()).getId();
        if (Objects.nonNull(getByDni(user.getDni()))) {
            this.userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
