package com.dustdrive.infodustdrive.service;

import com.dustdrive.infodustdrive.dto.repair_shop.NearRepairShopRequestDto;
import com.dustdrive.infodustdrive.dto.repair_shop.NearRepairShopResponseDto;
import com.dustdrive.infodustdrive.entity.RepairShop;
import com.dustdrive.infodustdrive.repository.MongoRepairShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairShopService {
    private final MongoRepairShopRepository repairShopRepository;

    // 가까운 정비소 조회
    public NearRepairShopResponseDto findNearRepairShop(NearRepairShopRequestDto nearRepairShopRequestDto) {
        List<RepairShop> repairShopNear = repairShopRepository
                .findRepairShopNear(nearRepairShopRequestDto.getLocation());

        // 10개로 자르기
        repairShopNear = repairShopNear.stream().limit(10).toList();

        return NearRepairShopResponseDto.builder()
                .repairShops(repairShopNear)
                .build();
    }

    // 모든 정비소 조회
    public List<RepairShop> findAll() {

//        // testData
//        RepairShop repairShop = new RepairShop();
//        repairShop.setShop("정비소1");
//        repairShop.setTel("000-000");
//        repairShop.setLocation(new Point(5.55,9.88));
//        repairShop.setAddress("주소");
//        repairShopRepository.create(repairShop);

        return repairShopRepository.findAll();
    }
}
