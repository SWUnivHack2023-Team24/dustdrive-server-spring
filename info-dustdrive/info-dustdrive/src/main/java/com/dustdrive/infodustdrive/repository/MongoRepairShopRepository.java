package com.dustdrive.infodustdrive.repository;

import com.dustdrive.infodustdrive.entity.RepairShop;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class MongoRepairShopRepository {
    private final SpringDataMongoRepairShopRepository repository;

    public String create(RepairShop repairShop) {
        RepairShop savedRepairShop = repository.save(repairShop);
        return savedRepairShop.getId();
    }

    public RepairShop findById(String id) {
        return repository.findById(id).get();
    }

    public List<RepairShop> findRepairShopNear(Point location) {
        Distance distance = new Distance(20, Metrics.KILOMETERS);
        return repository.findByLocationNear(location, distance);
    }

    public List<RepairShop> findAll() {
        return repository.findAll();
    }
}
