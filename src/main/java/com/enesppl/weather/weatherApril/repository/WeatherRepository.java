package com.enesppl.weather.weatherApril.repository;

import com.enesppl.weather.weatherApril.dto.WeatherDto;
import com.enesppl.weather.weatherApril.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherEntity,String> {




    // Select * from entity where requestedCityName by updateTime desc limit1
     Optional<WeatherEntity> findFirstByRequestedCityNameOrderByUpdatedTimeDesc(String city);






}
