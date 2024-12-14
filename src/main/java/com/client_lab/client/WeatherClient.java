package com.client_lab.client;

import com.client_lab.dto.weather.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url="http://api.weatherstack.com", name= "weather-client")
public interface WeatherClient {

    @GetMapping("/current")
    WeatherResponse getCurrentWeather(@RequestParam("access_key") String access_key,
                                      @RequestParam ("query")String query);

}

