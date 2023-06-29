package com.dustdrive.infodustdrive.dto.weather;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class WeatherResponseDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate localDate;
    private String city;
    private Double temperature;
    private String description;

    @Builder
    public WeatherResponseDto(LocalDate localDate, String city, Double temperature, String description) {
        this.localDate = localDate;
        this.city = city;
        this.temperature = temperature;
        this.description = description;
    }


}
