package com.dustdrive.infodustdrive.service;

import com.dustdrive.infodustdrive.dto.fine_dust.FineDustInfoRequestDto;
import com.dustdrive.infodustdrive.dto.fine_dust.FineDustInfoResponseDto;
import com.dustdrive.infodustdrive.dto.fine_dust.date.FineDustDateRequestDto;
import com.dustdrive.infodustdrive.dto.fine_dust.date.FineDustDateResponseDto;
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
        fineDustDateResponseDto.setSuccess(responseDto.getSuccess());
        fineDustDateResponseDto.setError(responseDto.getError());
        fineDustDateResponseDto.setStatus(responseDto.getStatus());

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
        fineDustRealTimeResponseDto.setSuccess(responseDto.getSuccess());
        fineDustRealTimeResponseDto.setError(responseDto.getError());
        fineDustRealTimeResponseDto.setStatus(responseDto.getStatus());

        return fineDustRealTimeResponseDto;
    }


}
