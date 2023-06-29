package com.dustdrive.infodustdrive.service;

import com.dustdrive.infodustdrive.dto.*;
import com.dustdrive.infodustdrive.entity.Car;
import com.dustdrive.infodustdrive.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    // 자동차 노후 여부 조회

    private final CarRepository carRepository;

    public CarInfoResponseDto checkCarInfo(CarInfoRequestDto carInfoRequestDto) {
        // Data 가져오기
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://fdata.dustdrive.info/owner_data";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        CarDataRequestDto carDataRequestDto = new CarDataRequestDto();
        carDataRequestDto.setOwnername(carInfoRequestDto.getUserName());
        carDataRequestDto.setReginumber(carInfoRequestDto.getCarNumber());

        HttpEntity<CarDataRequestDto> request = new HttpEntity<>(carDataRequestDto, headers);

        ResponseEntity<CarDataResponseDto> response = restTemplate.postForEntity(url, request, CarDataResponseDto.class);
        CarDataResponseDto dataResponseDto = response.getBody();

        // Data 확인하기
        Boolean isUnavailable = false;

        if ((!dataResponseDto.getData().equals("diesel")) || dataResponseDto.getData().getFuelEffRank() >= 4) {
            isUnavailable = true;
        }

        return CarInfoResponseDto.builder()
                .isUnavailable(isUnavailable)
                .carType(dataResponseDto.getData().getCarType())
                .carNum(dataResponseDto.getData().getVhcNo())
                .userName(dataResponseDto.getData().getName())
                .fuelEffRank(dataResponseDto.getData().getFuelEffRank())
                .build();
    }

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
