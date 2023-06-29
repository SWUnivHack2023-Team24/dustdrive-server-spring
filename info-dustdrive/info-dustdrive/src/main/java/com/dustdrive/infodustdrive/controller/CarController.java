package com.dustdrive.infodustdrive.controller;

import com.dustdrive.infodustdrive.dto.car.CarInfoRequestDto;
import com.dustdrive.infodustdrive.dto.car.CarInfoResponseDto;
import com.dustdrive.infodustdrive.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    // 자동차 통행 여부 확인
    @GetMapping("/api/v1/car/check")
    public CarInfoResponseDto checkCarInfo(@RequestBody CarInfoRequestDto carInfoRequestDto) {
        return carService.checkCarInfo(carInfoRequestDto);
    }
}
