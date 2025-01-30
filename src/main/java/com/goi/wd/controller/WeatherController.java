package com.goi.wd.controller;


import com.goi.wd.service.StationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    private StationService stationService;

    @GetMapping("/station/{id}")
    public ResponseEntity<?> getStation(@PathVariable String id) {
        try {
            if ("all".equals(id)) {
                return ResponseEntity.ok(stationService.getAllStations());
            } else {
                int stationId = Integer.parseInt(id);
                return ResponseEntity.ok(stationService.getStationById(stationId));
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid station ID format");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/weather/{id}")
    public ResponseEntity<?> getStationWeather(@PathVariable int id) {
        try {
            return ResponseEntity.ok(stationService.getStationWeather(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while fetching weather data: " + e.getMessage());
        }
    }
}