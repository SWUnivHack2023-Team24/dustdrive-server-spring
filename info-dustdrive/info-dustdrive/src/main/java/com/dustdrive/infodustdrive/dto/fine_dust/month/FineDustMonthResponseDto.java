package com.dustdrive.infodustdrive.dto.fine_dust.month;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FineDustMonthResponseDto {
    private List<FineDustMonthDataDto> data;

    @Builder
    public FineDustMonthResponseDto(List<FineDustMonthDataDto> data) {
        this.data = data;
    }
}
