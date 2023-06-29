package com.dustdrive.infodustdrive.repository;

import com.dustdrive.infodustdrive.entity.RepairShop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;

import java.util.List;

@SpringBootTest
class MongoRepairShopRepositoryTest {
    @Autowired
    private MongoRepairShopRepository repairShopRepository;

    @Test
    public void 주어진_거리_내_정비소_조회() throws Exception {
        // given
        RepairShop repairShop = new RepairShop();
        Point cor = new Point(127.080, 37.251);
        repairShop.setName("착한피자");
        repairShop.setLocation(cor);
        repairShopRepository.create(repairShop);

        // when
        Point orderCoordinate = new Point(127.074, 37.252);
        List<RepairShop> restaurantNear = repairShopRepository.findRepairShopNear(orderCoordinate);

        // then

    }

}