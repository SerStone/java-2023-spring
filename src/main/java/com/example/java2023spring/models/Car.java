package com.example.java2023spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor

public class Car {

    @Id
    private String id;
    private String model;
    private int power;
    private String producer;

}
