package com.enesppl.weather.weatherApril.dto;

import com.enesppl.weather.weatherApril.model.WeatherEntity;

public record WeatherDto(
        String cityName,
        String countryName,
        Integer temperature
) {
 public   static WeatherDto convert(WeatherEntity from){
        return new WeatherDto(from.getCityName()
                            , from.getCountry()
                            , from.getTemperature());
    }






}
