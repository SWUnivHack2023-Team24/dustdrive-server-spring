package com.dustdrive.infodustdrive.service;

import com.dustdrive.infodustdrive.dto.fine_dust.FineDustInfoRequestDto;
import com.dustdrive.infodustdrive.dto.fine_dust.FineDustInfoResponseDto;
import com.dustdrive.infodustdrive.dto.fine_dust.date.FineDustDateRequestDto;
import com.dustdrive.infodustdrive.dto.fine_dust.date.FineDustDateResponseDto;
import com.dustdrive.infodustdrive.dto.fine_dust.month.FineDustMonthDataRequestDto;
import com.dustdrive.infodustdrive.dto.fine_dust.month.FineDustMonthDataResponseDto;
import com.dustdrive.infodustdrive.dto.fine_dust.month.FineDustMonthRequestDto;
import com.dustdrive.infodustdrive.dto.fine_dust.month.FineDustMonthResponseDto;
import com.dustdrive.infodustdrive.dto.fine_dust.real_time.FineDustRealTimeRequestDto;
import com.dustdrive.infodustdrive.dto.fine_dust.real_time.FineDustRealTimeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FineDustService {

    /**
     * 미세먼지 이전 30일 + 이후 예상 7일 조회
     */
    public FineDustMonthResponseDto findMonthly(FineDustMonthRequestDto fineDustMonthRequestDto) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://predict.dustdrive.info/predict_monthly";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 수정하기
        FineDustMonthDataRequestDto requestDto = FineDustMonthDataRequestDto.builder()
                .region(fineDustMonthRequestDto.getRegion())
                .date(fineDustMonthRequestDto.getDate())
                .build();

        HttpEntity<FineDustMonthDataRequestDto> request
                = new HttpEntity<>(requestDto, headers);

        ResponseEntity<FineDustMonthDataResponseDto> response
                = restTemplate.postForEntity(url, request, FineDustMonthDataResponseDto.class);

        FineDustMonthDataResponseDto body = response.getBody();

        // 수정하기
        return FineDustMonthResponseDto.builder()
                .data(body.getData())
                .build();
    }

    /**
     * 미세먼지 날짜별 확인
     */
    public FineDustDateResponseDto checkFineDust_Date(FineDustDateRequestDto fineDustDateRequestDto) {
        // Data 가져오기
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://predict.dustdrive.info/predict";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        FineDustInfoRequestDto requestDto = FineDustInfoRequestDto.builder()
                .date(fineDustDateRequestDto.getLocalDate())
                .fueleffrank(fineDustDateRequestDto.getFuelEffRank())
                .region(fineDustDateRequestDto.getAddress())
                .build();

        HttpEntity<FineDustInfoRequestDto> request
                = new HttpEntity<>(requestDto, headers);

        ResponseEntity<FineDustInfoResponseDto> response
                = restTemplate.postForEntity(url, request, FineDustInfoResponseDto.class);
        FineDustInfoResponseDto responseDto = response.getBody();

        FineDustDateResponseDto fineDustDateResponseDto = new FineDustDateResponseDto();

        // 데이터 임시로
        fineDustDateResponseDto.setData(responseDto.getData());

        // 테스트용
        fineDustDateResponseDto.setLocalDate(fineDustDateRequestDto.getLocalDate());

        return fineDustDateResponseDto;
    }

    /**
     * 미세먼지 실시간 확인
     */
    public FineDustRealTimeResponseDto checkFineDust_RealTime(FineDustRealTimeRequestDto fineDustRealTimeRequestDto) {
        // Data 가져오기
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://predict.dustdrive.info/predict";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        FineDustInfoRequestDto requestDto = FineDustInfoRequestDto.builder()
                .fueleffrank(fineDustRealTimeRequestDto.getFuelEffRank())
                .region(fineDustRealTimeRequestDto.getAddress())
                .build();
        requestDto.setDate(LocalDate.now());    // 실시간은 현재 날짜 기준으로

        HttpEntity<FineDustInfoRequestDto> request
                = new HttpEntity<>(requestDto, headers);

        ResponseEntity<FineDustInfoResponseDto> response
                = restTemplate.postForEntity(url, request, FineDustInfoResponseDto.class);
        FineDustInfoResponseDto responseDto = response.getBody();

        FineDustRealTimeResponseDto fineDustRealTimeResponseDto = new FineDustRealTimeResponseDto();

        // 데이터 임시로
        fineDustRealTimeResponseDto.setData(responseDto.getData());

        // 테스트용
        fineDustRealTimeResponseDto.setLocalDate(requestDto.getDate());

        return fineDustRealTimeResponseDto;
    }
}
