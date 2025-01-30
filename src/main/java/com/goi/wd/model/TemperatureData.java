package com.goi.wd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TemperatureData {
    private float maxValue;
    private float maxDeparture;
    private float minValue;
    private float minDeparture;

    public TemperatureData(float maxValue, float maxDeparture, float minValue, float minDeparture) {
        this.maxValue = maxValue;
        this.maxDeparture = maxDeparture;
        this.minValue = minValue;
        this.minDeparture = minDeparture;
    }

    // Getters and setters
}