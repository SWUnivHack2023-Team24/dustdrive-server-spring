package com.dustdrive.infodustdrive.controller;

import com.dustdrive.infodustdrive.service.FineDustService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FineDustController {
    private final FineDustService fineDustService;

    // 미세먼지 농도 조회

}