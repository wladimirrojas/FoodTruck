package com.foodapp.foodtruck.repository;

import com.foodapp.foodtruck.dto.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<UserDto, String> {

    @Query("{dni: '?0'}")
    UserDto findUserByDni(String dni);

    @Query("{'age': {$gte: ?0, $lte: ?1}}")
    int getRangeAge(int age1, int age2);
}
