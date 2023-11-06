package com.example.java2023spring.service.Implementation;

import com.example.java2023spring.dao.CarDAO;
import com.example.java2023spring.models.Car;
import com.example.java2023spring.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarServiceImpl1 implements CarService {

    private CarDAO carDAO;

    @Override
    public List<Car> getCars() {
        return carDAO.findAll();
    }

    @Override
    public Car getCar(String id) {
        return carDAO.findById(id).get();
    }

    @Override
    public void saveCar(Car car) {
        carDAO.save(car);
    }

    @Override
    public void deleteCar(String id) {
        carDAO.delete(carDAO.findById(id).get());

    }
}