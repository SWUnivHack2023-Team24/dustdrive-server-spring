package com.dustdrive.infodustdrive.dto.car;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CarInfoResponseDto {
    private Boolean isUnavailable;  // true일 경우
    private String userName;
    private String carNum;
    private String carType;
    private int fuelEffRank;
    private int year;

    @Builder
    public CarInfoResponseDto(Boolean isUnavailable, String userName, String carNum, String carType, int fuelEffRank,int year) {
        this.isUnavailable = isUnavailable;
        this.userName = userName;
        this.carNum = carNum;
        this.carType = carType;
        this.fuelEffRank = fuelEffRank;
        this.year = year;
    }

}
