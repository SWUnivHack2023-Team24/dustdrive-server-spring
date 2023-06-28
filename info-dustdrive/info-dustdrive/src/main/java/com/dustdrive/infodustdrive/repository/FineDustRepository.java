package com.dustdrive.infodustdrive.repository;

import com.dustdrive.infodustdrive.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FineDustRepository extends MongoRepository<Car, String> {
}
