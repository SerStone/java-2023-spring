package com.example.java2023spring.service.Implementation;

import com.example.java2023spring.dao.CarDAO;
import com.example.java2023spring.models.Car;
import com.example.java2023spring.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarServiceImpl2 implements CarService {

    private CarDAO carDAO;

    @Override
    public List<Car> getCars() {
        return carDAO.findAll();
    }

    @Override
    public Car getCar(String id) {
        if (id.isEmpty() || id == null) {
            throw new RuntimeException("id is bad");
        }
        return carDAO.findById(id).orElseGet(Car::new);
    }

    @Override
    public void saveCar(Car car) {
        if (car == null) {
            throw new RuntimeException("car cannot be null");
        }
        carDAO.save(car);

    }

    @Override
    public void deleteCar(String id) {
        carDAO.deleteById(id);

    }
}