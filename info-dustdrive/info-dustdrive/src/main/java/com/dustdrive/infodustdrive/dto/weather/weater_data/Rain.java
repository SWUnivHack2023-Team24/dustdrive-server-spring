package com.dustdrive.infodustdrive.dto.weather.weater_data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rain {
    @JsonProperty("1h")
    private double hour;
}
