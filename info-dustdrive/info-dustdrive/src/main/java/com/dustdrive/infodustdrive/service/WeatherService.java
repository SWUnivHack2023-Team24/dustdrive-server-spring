package com.dustdrive.infodustdrive.service;

import com.dustdrive.infodustdrive.dto.weather.WeatherDataResponseDto;
import com.dustdrive.infodustdrive.dto.weather.WeatherRequestDto;
import com.dustdrive.infodustdrive.dto.weather.WeatherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WeatherService {
    public WeatherResponseDto findWeather(WeatherRequestDto weatherRequestDto) {
        // Data 가져오기
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.openweathermap.org/data/2.5/weather?lat="
                + weatherRequestDto.getLat()
                + "&lon=" +
                weatherRequestDto.getLon() +
                "&appid=" +
                "9b912b5e97037972a95832c5ee150500&lang=kr\n";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<WeatherDataResponseDto> response = restTemplate.getForEntity(url, WeatherDataResponseDto.class);

        WeatherDataResponseDto responseDto = response.getBody();

        // Data 확인하기
        Boolean isUnavailable = false;

        return WeatherResponseDto.builder()
                .localDate(LocalDate.now())
                .city(responseDto.getName())
                .temperature(responseDto.getMain().getTemp())
                .description(responseDto.getWeather().get(0).getDescription())
                .build();
    }


}
