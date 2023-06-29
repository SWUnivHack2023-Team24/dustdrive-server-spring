package com.dustdrive.infodustdrive.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CarInfoRequestDto {

    private String userName;
    private String carNumber;

    @Builder
    public CarInfoRequestDto(String carNumber, String userName) {
        this.carNumber = carNumber;
        this.userName = userName;
    }
}
