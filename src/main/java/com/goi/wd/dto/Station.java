package com.goi.wd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station {
    private int stationId;
    private String station;
    private String jurisdiction;
    private String region;

}