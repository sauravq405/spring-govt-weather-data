package com.goi.wd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HumidityData {
    private float morning;
    private float evening;

    public HumidityData(float morning, float evening) {
        this.morning = morning;
        this.evening = evening;
    }

    // Getters and setters
}
