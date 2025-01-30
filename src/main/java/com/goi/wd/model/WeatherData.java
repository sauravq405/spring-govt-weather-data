package com.goi.wd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    private TemperatureData temperature;
    private HumidityData humidity;
    private AstronomicalData astronomical;
    private List<ForecastDay> forecast;

    // Getters and setters
}