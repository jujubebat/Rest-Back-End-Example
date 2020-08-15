package com.jujubebat.service;

import com.jujubebat.model.Car;
import com.jujubebat.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> getCars(){
        return carRepository.findAll();
    }
}
