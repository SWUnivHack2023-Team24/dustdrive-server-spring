package com.dustdrive.infodustdrive.dto.weather;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class WeatherRequestDto {
    private double lat;
    private double lon;
}
