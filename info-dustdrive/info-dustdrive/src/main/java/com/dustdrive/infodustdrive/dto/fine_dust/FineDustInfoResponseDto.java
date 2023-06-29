package com.dustdrive.infodustdrive.dto.fine_dust;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FineDustInfoResponseDto {

    // 임시
    private FineDustDataDto data;
    private String error;
    private String errorMessage;
    private int status;
    private Boolean success;

}