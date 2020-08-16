package com.jujubebat.controller.api;

import com.jujubebat.dto.ProductDetailResponseDto;
import com.jujubebat.model.Car;
import com.jujubebat.model.ProductDetail;
import com.jujubebat.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/cars")
public class CarApiController {

    private final CarService carService;

    @Autowired
    public CarApiController(CarService carService){
        this.carService = carService;
    }

    /*
    @GetMapping
    public List<Car> getCars(){
        return carService.getCars();
    }
    */

    @GetMapping(path = "/{speed}")
    public List<Car> getCars(@PathVariable(name = "speed") String speed){
        return carService.getCarBySpeed(speed);
    }

}
