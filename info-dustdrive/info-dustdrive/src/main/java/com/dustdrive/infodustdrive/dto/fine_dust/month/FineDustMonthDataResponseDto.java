package com.dustdrive.infodustdrive.dto.fine_dust.month;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FineDustMonthDataResponseDto {
    private List<FineDustMonthDataDto> data;
    private String error;
    private String errorMessage;
    private int status;
    private Boolean success;

    @Builder
    public FineDustMonthDataResponseDto(List<FineDustMonthDataDto> data, String error,
                                        String errorMessage, int status, Boolean success) {
        this.data = data;
        this.error = error;
        this.errorMessage = errorMessage;
        this.status = status;
        this.success = success;
    }
}
