package com.goi.wd.dto;

import com.goi.wd.model.WeatherData;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherDataResponse {
    private int code;
    private WeatherData result;

    public WeatherDataResponse(int code, WeatherData result) {
        this.code = code;
        this.result = result;
    }
}