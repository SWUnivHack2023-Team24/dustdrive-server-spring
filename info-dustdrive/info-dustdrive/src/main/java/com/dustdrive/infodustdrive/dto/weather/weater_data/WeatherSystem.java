package com.dustdrive.infodustdrive.dto.weather.weater_data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeatherSystem {
    private int type;
    private int id;
    private String country;
    private Long sunrise;
    private Long sunset;
}
