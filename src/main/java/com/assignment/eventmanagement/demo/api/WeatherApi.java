package com.assignment.eventmanagement.demo.api;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherApi {
    private long id;
    private Coordinate coordinate;
    private List<Weather> weather;
    private Main main;
    private Wind wind;

    @Getter
    @Setter
    public static class Coordinate {
        private float lon;
        private float lat;
    }

    @Getter
    @Setter
    public static class Weather {
        private long id;
        private String main;
        private String description;
        private String icon;
    }

    @Getter
    @Setter
    public static class Main {
        private float temp;
        private float feels_like;
        private float temp_min;
        private float temp_max;
        private long pressure;
        private int humidity;
    }

    @Getter
    @Setter
    public static class Wind {
        private float speed;
        private int deg;
    }
}
