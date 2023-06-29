package com.dustdrive.infodustdrive.dto.car;

import lombok.*;

/**
 * 실제 데이터에서 가져온 정보
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDataResponseDto {
    private CarDataDto data;
    private String error;
    private int status;
    private Boolean success;
}

