package com.dustdrive.infodustdrive.controller;

import com.dustdrive.infodustdrive.dto.weather.WeatherRequestDto;
import com.dustdrive.infodustdrive.dto.weather.WeatherResponseDto;
import com.dustdrive.infodustdrive.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;
    @GetMapping("/api/v1/weather")
    public WeatherResponseDto currentWeather(@RequestBody WeatherRequestDto weatherRequestDto) {
        return weatherService.findWeather(weatherRequestDto);
    }
}
