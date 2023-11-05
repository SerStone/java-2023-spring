package com.example.java2023spring.services;

import com.example.java2023spring.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class MailService {
    private final MailSender mailSender;

    public void  notifyCreatedCar(CarDto createdCar) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(System.getProperty("spring.mail.username"));
        message.setTo("mishagoal752@gmail.com");
        message.setSubject("New car");
        message.setText("A new car was created recently id: %d, model: %s, producer: %s, power: %d".formatted(createdCar.getId(), createdCar.getModel(), createdCar.getProducer(), createdCar.getPower()));
        mailSender.send(message);
    }

    public void  notifyDeletedCar(int id) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(System.getProperty("spring.mail.username"));
        message.setTo("mishagoal752@gmail.com");
        message.setSubject("Deleted car");
        message.setText("A car was created recently with id: %d".formatted(id));
        mailSender.send(message);
    }
}
