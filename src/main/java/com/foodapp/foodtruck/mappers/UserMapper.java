package com.foodapp.foodtruck.mappers;

import com.foodapp.foodtruck.dto.UserDto;
import com.foodapp.foodtruck.model.User;

import java.util.Objects;

public class UserMapper {

    public User dtoToModel(UserDto userDto) {
        if (Objects.nonNull(userDto)) {
            return User.builder()
                    .id(userDto.getId())
                    .name(userDto.getName())
                    .age(userDto.getAge())
                    .dni(userDto.getDni())
                    .build();
        }
        return null;
    }
}
