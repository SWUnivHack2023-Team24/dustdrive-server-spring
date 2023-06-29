package com.dustdrive.infodustdrive.dto.fine_dust.month;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class FineDustMonthDataDto {
    private String date;
    private String dust_info;
}
