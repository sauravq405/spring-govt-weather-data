package com.goi.wd.service;

import com.goi.wd.model.*;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherScraperService {

    public WeatherData getStationData(int id) throws IOException {
        String url = String.format("http://city.imd.gov.in/citywx/city_weather.php?id=%d", id);
        Document document = Jsoup.connect(url).get();
        Elements cells = document.select("td");

        WeatherData weatherData = new WeatherData();

        // Extract and set temperature data
        weatherData.setTemperature(new TemperatureData(
                Float.parseFloat(cells.get(4).text().trim()),
                Float.parseFloat(cells.get(6).text().trim()),
                Float.parseFloat(cells.get(8).text().trim()),
                Float.parseFloat(cells.get(10).text().trim())
        ));

        // Extract and set humidity data
        weatherData.setHumidity(new HumidityData(
                Float.parseFloat(cells.get(14).text().trim()),
                Float.parseFloat(cells.get(16).text().trim())
        ));

        // Extract and set astronomical data
        weatherData.setAstronomical(new AstronomicalData(
                cells.get(20).text().trim(),
                cells.get(18).text().trim(),
                cells.get(24).text().trim(),
                cells.get(22).text().trim()
        ));

        // Extract and set forecast data
        List<ForecastDay> forecast = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            int baseIndex = 31 + i * 5;  // Adjusting index for each day's data
            forecast.add(new ForecastDay(
                    i + 1,
                    cells.get(baseIndex).select("font").text().trim(),
                    Float.parseFloat(cells.get(baseIndex + 2).select("font").text().trim()),
                    Float.parseFloat(cells.get(baseIndex + 1).select("font").text().trim()),
                    cells.get(baseIndex + 4).select("font").text().trim()
            ));
        }
        weatherData.setForecast(forecast);

        return weatherData;
    }
}
