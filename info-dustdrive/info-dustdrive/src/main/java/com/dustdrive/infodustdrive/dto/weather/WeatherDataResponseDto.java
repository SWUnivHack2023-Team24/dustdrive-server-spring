package com.dustdrive.infodustdrive.dto.weather;

import com.dustdrive.infodustdrive.dto.weather.weater_data.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WeatherDataResponseDto {
    private Coordinate coord;
    private List<Weather> weather;
    private String base;
    private WeatherMainInfo main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Cloud clouds;
    private Long dt;
    private WeatherSystem sys;
    private Long timezone;
    private Long id;
    private String name;
    private Long cod;

}
