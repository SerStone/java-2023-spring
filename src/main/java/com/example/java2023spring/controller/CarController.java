package com.example.java2023spring.controller;

import com.example.java2023spring.models.Car;
import com.example.java2023spring.service.CarService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cars")
@RestController
public class CarController {
    // ????????

    final CarService carService;

    public CarController(@Qualifier("carServiceImpl2") CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public ResponseEntity<List<Car>> getCars() {

        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable String id) {
        return new ResponseEntity<>(carService.getCar(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void saveCar(@RequestBody Car car) {
        carService.saveCar(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCar(@PathVariable String id) {
        carService.deleteCar(id);

    }


}
