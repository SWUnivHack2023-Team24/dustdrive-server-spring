package com.dustdrive.infodustdrive.service;

import com.dustdrive.infodustdrive.repository.MongoRepairShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepairShopService {
    private final MongoRepairShopRepository repairShopRepository;
}
