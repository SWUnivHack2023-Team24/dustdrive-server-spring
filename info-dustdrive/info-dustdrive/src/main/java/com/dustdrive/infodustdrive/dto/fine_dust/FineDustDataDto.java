package com.dustdrive.infodustdrive.dto.fine_dust;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FineDustDataDto {
    private String dust_info;

    @Builder
    public FineDustDataDto(String dust_info) {
        this.dust_info = dust_info;
    }
}
