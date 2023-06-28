package com.dustdrive.infodustdrive.service;

import com.dustdrive.infodustdrive.entity.Car;
import com.dustdrive.infodustdrive.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    // 자동차 노후 여부 조회

    private final CarRepository carRepository;

    public Car findById(String id) {
        return carRepository.findById(id).get();
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car update(Car car, String id) {
        Car updateCar = carRepository.findById(id).orElse(null);
        updateCar.updateInfo(car);
        return carRepository.save(updateCar);
    }

    public boolean deleteById(String id) {
        carRepository.deleteById(id);
        return true;
    }
}
