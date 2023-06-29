package com.dustdrive.infodustdrive.dto.weather.weater_data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Wind {
    private double speed;
    private Long deg;
    private double gust;
}
