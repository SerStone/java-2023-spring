package com.example.java2023spring.services;

import com.example.java2023spring.dto.CarDto;
import com.example.java2023spring.mappers.CarMapper;
import com.example.java2023spring.models.Car;
import com.example.java2023spring.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final MailService mailService;

    public List<CarDto> getAll() {
        return this.carRepository.findAll().stream().map(carMapper::toDto).toList();
    }

    public Optional<CarDto> getById(int id){

        return this.carRepository.findById(id).stream().map(carMapper::toDto).findFirst();
    }

    public CarDto create(CarDto carDto) {
        CarDto createdCar = carMapper.toDto(this.carRepository.save(carMapper.toEntity(carDto)));
        this.mailService.notifyCreatedCar(createdCar);

        return createdCar;
    }

    public void deleteById(int id){
        this.carRepository.deleteById(id);
        this.mailService.notifyDeletedCar(id);

    }

    public List<CarDto> getByPower(int power) {
        return this.carRepository.findAllByPower(power).stream().map(carMapper::toDto).toList();
    }

    public List<CarDto> getByProducer(String producer) {

        return this.carRepository.findAllByProducer(producer).stream().map(carMapper::toDto).toList();
    }

    public CarDto uploadPhotoById(int id, MultipartFile file) throws IOException {
        Car car = this.carRepository.findById(id).orElseThrow();
        String originalFilename = file.getOriginalFilename();
        String path = System.getProperty("user.home") + File.separator + "carFolder" + File.separator + originalFilename;
        file.transferTo(new File(path));
        car.setPhoto(originalFilename);
        Car savedCar = this.carRepository.save(car);

        return this.carMapper.toDto(savedCar);
    }
}
