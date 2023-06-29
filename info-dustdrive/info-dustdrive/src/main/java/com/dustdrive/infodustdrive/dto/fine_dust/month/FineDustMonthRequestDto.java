package com.dustdrive.infodustdrive.dto.fine_dust.month;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FineDustMonthRequestDto {
    private String region;
    private String date;

    @Builder
    public FineDustMonthRequestDto(String region, String date) {
        this.region = region;
        this.date = date;
    }

}
