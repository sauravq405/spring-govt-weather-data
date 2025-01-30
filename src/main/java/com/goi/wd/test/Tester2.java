package com.goi.wd.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.HttpURLConnection;
import java.net.URL;

public class Tester2 {
    public static void main(String[] args) {
        String originalUrl = String.format("http://city.imd.gov.in/citywx/city_weather.php?id=%d", 43003);
        try {
            URL url = new URL(originalUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setInstanceFollowRedirects(false); // We handle redirects manually
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                String newUrl = connection.getHeaderField("Location");
                System.out.println("Server redirect to: " + newUrl);
                // Correct the URL if it's wrong
                String correctedNewUrl = newUrl.replace("city.imd.gov.incitywx", "city.imd.gov.in/citywx");
                System.out.println("Corrected redirect to: " + correctedNewUrl);
                Document document = Jsoup.connect(correctedNewUrl).get();
                System.out.println(document.toString());
            } else {
                Document document = Jsoup.connect(originalUrl).get();
                System.out.println(document.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
