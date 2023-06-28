package com.dustdrive.infodustdrive.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "car")
public class Car {
    @Id
    private String id;

    private Long number;

    public void updateInfo(Car car) {
        this.id = car.id;
        this.number = car.number;
    }
}
