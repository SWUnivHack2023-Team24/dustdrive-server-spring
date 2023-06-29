package com.dustdrive.infodustdrive.dto.weather.weater_data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Weather {
    private Long id;
    private String main;
    private String description;
    private String icon;
}
