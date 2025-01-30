package com.goi.wd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastDay {
    private int day;
    private String date;
    private float max;
    private float min;
    private String condition;

    public ForecastDay(int day, String date, float max, float min, String condition) {
        this.day = day;
        this.date = date;
        this.max = max;
        this.min = min;
        this.condition = condition;
    }

    // Getters and setters
}
