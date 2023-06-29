package com.dustdrive.infodustdrive.dto.weather.weater_data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeatherMainInfo {
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Long pressure;
    private Long humidity;
    private Long sea_level;
    private Long grnd_level;
}
