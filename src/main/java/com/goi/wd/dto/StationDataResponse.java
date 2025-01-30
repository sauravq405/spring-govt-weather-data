package com.goi.wd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StationDataResponse {
    private int code;
    private Object result;

    public StationDataResponse(int code, Object result) {
        this.code = code;
        this.result = result;
    }
}
