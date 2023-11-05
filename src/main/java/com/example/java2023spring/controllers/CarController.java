package com.example.java2023spring.controllers;

import com.example.java2023spring.dto.CarDto;
import com.example.java2023spring.models.Car;
import com.example.java2023spring.services.CarService;
import com.example.java2023spring.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cars")
public class CarController {
    private final CarService carService;

    @JsonView(View.level3.class)
    @GetMapping
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(this.carService.getAll());
    }

    @PostMapping
    public ResponseEntity<CarDto> create(@RequestBody @Valid CarDto car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.carService.create(car));
    }

    @JsonView(View.level1.class)
    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getById(@PathVariable int id) {
        return ResponseEntity.of(this.carService.getById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        this.carService.deleteById(id);
    }

    @JsonView(View.level2.class)
    @GetMapping("/power/{value}")
    public ResponseEntity<List<CarDto>> getByPower(@PathVariable int value) {
        return ResponseEntity.ok(this.carService.getByPower(value));
    }

    @JsonView(View.level2.class)
    @GetMapping("/producer/{value}")
    public ResponseEntity<List<CarDto>> getByProducer(@PathVariable String value) {
        return ResponseEntity.ok(this.carService.getByProducer(value));
    }
    @SneakyThrows
    @JsonView(View.level1.class)
    @PostMapping("/{id}/photo")
    public ResponseEntity<CarDto> uploadPhotoById(@PathVariable int id, MultipartFile photo) {
        return ResponseEntity.ok(this.carService.uploadPhotoById(id, photo));
    }

}
