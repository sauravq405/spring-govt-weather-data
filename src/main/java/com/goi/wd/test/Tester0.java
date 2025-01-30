package com.goi.wd.test;

import java.net.HttpURLConnection;
import java.net.URL;

public class Tester0 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://city.imd.gov.in/citywx/city_weather.php?id=43003");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code : " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
