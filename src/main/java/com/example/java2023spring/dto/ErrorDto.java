package com.example.java2023spring.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorDto {
    private List<String> messages;
}
