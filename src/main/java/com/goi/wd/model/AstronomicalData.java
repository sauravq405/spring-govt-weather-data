package com.goi.wd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AstronomicalData {
    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;

    public AstronomicalData(String sunrise, String sunset, String moonrise, String moonset) {
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
    }

    // Getters and setters
}
