package com.goi.wd.test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Tester3 {
    public static void main(String[] args) {
        String correctedUrl = "https://city.imd.gov.in/citywx/city_weather.php?id=43003";
        try {
            SSLContext sslContext = SSLContext.getInstance("TLSv1.2"); // or "TLSv1.3" if supported
            sslContext.init(null, null, null);
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            Document document = Jsoup.connect(correctedUrl)
                    .sslSocketFactory(sslSocketFactory)
                    .get();
            System.out.println(document.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
