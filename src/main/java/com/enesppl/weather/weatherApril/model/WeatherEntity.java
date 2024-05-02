package com.enesppl.weather.weatherApril.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WeatherEntity {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name= "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String requestCityNmae;
    private String cityName;
    private String country;
    private Integer temperature;
    private LocalDateTime updatedTime;

    private LocalDateTime responseLocalTime;







}
