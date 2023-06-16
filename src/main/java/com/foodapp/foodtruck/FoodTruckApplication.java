package com.foodapp.foodtruck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FoodTruckApplication{


    public static void main(String[] args) {
        SpringApplication.run(FoodTruckApplication.class, args);
    }
}

