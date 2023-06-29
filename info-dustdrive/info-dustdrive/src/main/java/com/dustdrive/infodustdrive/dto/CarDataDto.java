package com.dustdrive.infodustdrive.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarDataDto {
    private String name;
    private String vhcNo;
    private int fuelEffRank;
    private String carType;
    private String fuelType;
}
