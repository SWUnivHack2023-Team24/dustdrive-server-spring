package com.dustdrive.infodustdrive.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "car")
public class Car {
    @Id
    private String id;

    private Long number;

    private LocalDate localDate;

    private String type;

    public void updateInfo(Car car) {
        this.number = car.number;
    }
}
