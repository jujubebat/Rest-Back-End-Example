package com.jujubebat.service;

import com.jujubebat.model.Car;
import com.jujubebat.model.Product;
import com.jujubebat.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> getCars(){
        return carRepository.findAll();
    }

    public List<Car> getCarBySpeed(String speed){
        /*Optional<Car> car = carRepository.findBySpeed(speed);
        if(!car.isPresent()) return null;
        return car.get();
         */

       // return carRepository.findBySpeed(speed);

        System.out.println(" speed : " + speed);

        return carRepository.findBySpeed(speed);
    }
}

