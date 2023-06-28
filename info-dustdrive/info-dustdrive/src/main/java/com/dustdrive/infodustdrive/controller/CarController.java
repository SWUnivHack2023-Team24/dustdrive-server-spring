package com.dustdrive.infodustdrive.controller;

import com.dustdrive.infodustdrive.entity.Car;
import com.dustdrive.infodustdrive.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    // 자동차 통행 여부 확인
    @GetMapping("/api/v1/car")
    public List<Car> findAllCar() {
        return carService.findAll();
    }

    @PostMapping("/api/v1/car")
    public Car save(@RequestBody Car car) {
        return carService.save(car);
    }

}
