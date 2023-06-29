package com.dustdrive.infodustdrive.dto.repair_shop;

import com.dustdrive.infodustdrive.entity.RepairShop;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.PrimitiveIterator;

@Getter
@Setter
@NoArgsConstructor
public class NearRepairShopResponseDto {
    private int count;
    private List<RepairShop> nearRepairShopList;

    @Builder
    public NearRepairShopResponseDto(List<RepairShop> repairShops) {
        this.count = repairShops.size();
        this.nearRepairShopList = repairShops;
    }
}
