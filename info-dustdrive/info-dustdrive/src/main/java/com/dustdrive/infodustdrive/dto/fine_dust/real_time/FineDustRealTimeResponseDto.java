package com.dustdrive.infodustdrive.dto.fine_dust.real_time;

import com.dustdrive.infodustdrive.dto.fine_dust.FineDustDataDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class FineDustRealTimeResponseDto {
    /**
     * 임시!!
     */

    private FineDustDataDto data;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate localDate;
    private String error;
    private int status;
    private Boolean success;
}
