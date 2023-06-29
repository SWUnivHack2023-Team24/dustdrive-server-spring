package com.dustdrive.infodustdrive.dto.fine_dust;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class FineDustInfoRequestDto {
    private String region;
    private int fueleffrank;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Builder
    public FineDustInfoRequestDto(String region, int fueleffrank, LocalDate date) {
        this.region = region;
        this.fueleffrank = fueleffrank;
        this.date = date;
    }
}