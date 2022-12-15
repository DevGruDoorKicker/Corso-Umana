package com.business.cardatabase.web;

import com.business.cardatabase.domain.Car;
import com.business.cardatabase.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository repository;

    @RequestMapping ("/cars")
    public Iterable<Car> getCars(){
        return repository.findAll();
    }

}
