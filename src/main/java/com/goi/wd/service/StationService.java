package com.goi.wd.service;

import com.goi.wd.dto.Station;
import com.goi.wd.dto.StationDataResponse;
import com.goi.wd.dto.WeatherDataResponse;
import com.goi.wd.model.WeatherData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class StationService {

    private final WeatherScraperService weatherScraperService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Constructor for dependency injection
    @Autowired
    public StationService(WeatherScraperService weatherScraperService) {
        this.weatherScraperService = weatherScraperService;
    }

    // Method to get all stations from a JSON file
    public StationDataResponse getAllStations() throws IOException {
        File file = new ClassPathResource("stations.json").getFile();
        List<Station> stations = objectMapper.readValue(file, new TypeReference<List<Station>>() {});
        return new StationDataResponse(200, stations);
    }

    // Method to get a station by its ID
    public StationDataResponse getStationById(int id)  {
        List<Station> stations = null;
        try {
            stations = (List<Station>) getAllStations().getResult();
        } catch (IOException e) {
            log.error("Error caught",e);
            throw new RuntimeException(e);
        }
        for (Station station : stations) {
            if (station.getStationId() == id) {
                return new StationDataResponse(200, station);
            }
        }
        return new StationDataResponse(404, "No station with ID " + id + " found");
    }

    // Method to get weather data for a station
    public WeatherDataResponse getStationWeather(int id) throws IOException {
        WeatherData weatherData = weatherScraperService.getStationData(id);
        return new WeatherDataResponse(200, weatherData);
    }
}
