package com.enesppl.weather.weatherApril.service;


import com.enesppl.weather.weatherApril.dto.WeatherDto;
import com.enesppl.weather.weatherApril.dto.WeatherResponse;
import com.enesppl.weather.weatherApril.model.WeatherEntity;
import com.enesppl.weather.weatherApril.repository.WeatherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Service
public class WeatherService {



    //http://api.weatherstack.com/current?access_key=b03f51f88c3824ec158364c5c5817a28&query=Malatya
    private static final String API_URL = "http://api.weatherstack.com/current?access_key=b03f51f88c3824ec158364c5c5817axx&query="; // xx i kontrol et



    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public WeatherService(WeatherRepository weatherRepository,RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate=restTemplate;
    }

    public WeatherDto getWeatherByCityName(String city){

    Optional<WeatherEntity> weatherEntityOptional = weatherRepository.findFirstByRequestedCityNameOrderByUpdatedTimeDesc(city);
    if(!weatherEntityOptional.isPresent()){

        return WeatherDto.convert(getWeatherFromWeatherStack(city));

    }

    return WeatherDto.convert(weatherEntityOptional.get());

    }

        public WeatherEntity getWeatherFromWeatherStack(String city){

            ResponseEntity<String> responseEntity = restTemplate.getForEntity(API_URL+city,String.class);


            try {
                WeatherResponse weatherResponse = objectMapper.readValue(responseEntity.getBody(),WeatherResponse.class);
            } catch (JsonProcessingException e) {
                 throw new RuntimeException(e);
            }
        }



        private WeatherEntity saveWeatherEntity(String city, WeatherResponse weatherResponse){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            WeatherEntity weatherEntity = new WeatherEntity(city,
                    weatherResponse.location().name(),
                    weatherResponse.location().country().)

        }


}
