package com.dustdrive.infodustdrive.repository;

import com.dustdrive.infodustdrive.entity.RepairShop;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SpringDataMongoRepairShopRepository extends MongoRepository<RepairShop, String> {
    List<RepairShop> findByLocationNear(Point location, Distance distance);
}
