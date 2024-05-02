package com.enesppl.weather.weatherApril.dto;

public record Request(
        String type,
        String query,
        String language,
        String unit
) {
}
