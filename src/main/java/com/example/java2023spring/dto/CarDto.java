package com.example.java2023spring.dto;

import com.example.java2023spring.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {
    @JsonView(value = {View.level1.class})
    private int id;

    @JsonView(value = {View.level1.class, View.level2.class, View.level3.class})
    @NotBlank(message = "model required")
    @Size(min = 2, max = 20, message = "Min value of chars is {min} and max value is {max}")
    private String model;

    @JsonView(value = {View.level1.class, View.level2.class})
    @Min(value = 100, message = "Min value of power is {value}")
    @Max(value = 1000, message = "Min value of power is {value}")
    private int power;

    @JsonView(value = {View.level1.class, View.level2.class, View.level3.class})
    @NotBlank(message = "model required")
    @Size(min = 2, max = 20, message = "Min value of chars is {min} and max value is {max}")
    private String producer;
}
