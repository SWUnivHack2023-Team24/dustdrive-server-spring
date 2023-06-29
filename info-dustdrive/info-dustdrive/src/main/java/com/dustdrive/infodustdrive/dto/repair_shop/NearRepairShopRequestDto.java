package com.dustdrive.infodustdrive.dto.repair_shop;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

@Getter
@NoArgsConstructor
public class NearRepairShopRequestDto {
    private Point location;

    @Builder
    public NearRepairShopRequestDto(Point location) {
        this.location = location;
    }
}
