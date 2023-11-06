package com.example.java2023spring.dao;

import com.example.java2023spring.models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CarDAO extends MongoRepository<Car, String> {
}
