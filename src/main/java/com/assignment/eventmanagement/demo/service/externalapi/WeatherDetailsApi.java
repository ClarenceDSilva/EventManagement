package com.assignment.eventmanagement.demo.service.externalapi;

import com.assignment.eventmanagement.demo.api.WeatherApi;
import com.assignment.eventmanagement.demo.model.WeatherDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDetailsApi {

    private RestTemplate restTemplate;
    @Value("${external.api.url}")
    private String weatherApiUrl;
    @Value("${api.key}")
    private String apiKey;
    private WeatherApi weatherApi;

    public WeatherDetailsApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*
     * External API call to fetch the weather of the location
     * */
    public WeatherDetails fetchCurrentWeatherForLocation(String city) {
        WeatherDetails weatherDetails = new WeatherDetails();
        weatherApi = restTemplate.getForObject(weatherApiUrl+"?q="+city+"&appid="+apiKey+"&units=metric", WeatherApi.class);

        weatherDetails.setTemperature(weatherApi.getMain().getTemp());
        weatherDetails.setTemp_max(weatherApi.getMain().getTemp_max());
        weatherDetails.setTemp_min(weatherApi.getMain().getTemp_min());
        weatherDetails.setFeels_like(weatherApi.getMain().getFeels_like());
        weatherDetails.setPressure(weatherApi.getMain().getPressure());
        weatherDetails.setHumidity(weatherApi.getMain().getHumidity());
        weatherDetails.setSpeed(weatherApi.getWind().getSpeed());
        weatherDetails.setDeg(weatherApi.getWind().getDeg());

        return weatherDetails;
    }

}
