package com.example.java2023spring.repositories;

import com.example.java2023spring.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByProducer(String producer);

    List<Car> findAllByPower(int power);
}
