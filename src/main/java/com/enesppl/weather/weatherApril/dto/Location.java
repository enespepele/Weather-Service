package com.enesppl.weather.weatherApril.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(
        String name,
        String country,

        @JsonProperty("localtime")
        String localtime                                             //Camelcase yazmadık çünkü JSONda sorun olacak

) {
}
