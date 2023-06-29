package com.dustdrive.infodustdrive.controller;

import com.dustdrive.infodustdrive.dto.fine_dust.date.FineDustDateRequestDto;
import com.dustdrive.infodustdrive.dto.fine_dust.date.FineDustDateResponseDto;
import com.dustdrive.infodustdrive.dto.fine_dust.month.FineDustMonthRequestDto;
import com.dustdrive.infodustdrive.dto.fine_dust.month.FineDustMonthResponseDto;
import com.dustdrive.infodustdrive.dto.fine_dust.real_time.FineDustRealTimeResponseDto;
import com.dustdrive.infodustdrive.dto.fine_dust.real_time.FineDustRealTimeRequestDto;
import com.dustdrive.infodustdrive.service.FineDustService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FineDustController {
    private final FineDustService fineDustService;

    /**
     * 최근 세달 + 앞에 일주일 농도 조회
     */
    @GetMapping("/api/v1/dust")
    public FineDustMonthResponseDto monthlyFineDust(@RequestBody FineDustMonthRequestDto fineDustMonthRequestDto) {
        return fineDustService.findMonthly(fineDustMonthRequestDto);
    }

    /**
     * 날짜별 미세먼지 농도 조회
     */
    @GetMapping("/api/v1/dust/date")
    public FineDustDateResponseDto dateFineDust(@RequestBody FineDustDateRequestDto fineDustDateRequestDto) {
        return fineDustService.checkFineDust_Date(fineDustDateRequestDto);
    }

    /**
     * 실시간 미세먼지 농도 조회
     */
    @GetMapping("/api/v1/dust/realtime")
    public FineDustRealTimeResponseDto realTimeFineDust(@RequestBody FineDustRealTimeRequestDto fineDustRealtimeRequestDto) {
        return fineDustService.checkFineDust_RealTime(fineDustRealtimeRequestDto);
    }
}