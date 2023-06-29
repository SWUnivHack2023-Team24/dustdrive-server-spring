package com.dustdrive.infodustdrive.controller;

import com.dustdrive.infodustdrive.dto.repair_shop.NearRepairShopRequestDto;
import com.dustdrive.infodustdrive.dto.repair_shop.NearRepairShopResponseDto;
import com.dustdrive.infodustdrive.entity.RepairShop;
import com.dustdrive.infodustdrive.service.RepairShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RepairShopController {
    private final RepairShopService repairShopService;

    /**
     * 가까운 정비소 조회
     */
    @GetMapping("/api/v1/repairShop/near")
    public NearRepairShopResponseDto findNearRepairShop(@RequestBody NearRepairShopRequestDto nearRepairShopRequestDto){
        return repairShopService.findNearRepairShop(nearRepairShopRequestDto);
    }

    /**
     * 모든 정비소 조회
     */
    @GetMapping("/api/v1/repairShop")
    public List<RepairShop> findAllRepairShop() {
        return repairShopService.findAll();
    }
}
