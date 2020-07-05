package uk.co.waleed.Util;

//import org.springframework.boot.json.JsonParser;
//import org.springframework.boot.json.JsonParserFactory;
//import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GetCitiesInRadius {
    private GetLatLong latLong;
    private String xmlData;
    private static final String host = "www.freemaptools.com";
    private static final String referer = "https://www.freemaptools.com/find-cities-and-towns-inside-radius.htm";

    public GetCitiesInRadius(String cityName, int radius) throws IOException {
        double r = (1.60934 * radius);
        latLong = new GetLatLong(cityName);
        URL url = new URL("https://www.freemaptools.com/ajax/get-all-cities-inside.php?lat="
                + latLong.getLatitude() + "&lng=" + latLong.getLongitude() + "&sortaplha=0&radius=" + r);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Host", this.host);
        urlConnection.setRequestProperty("Referer", this.referer);

        urlConnection.connect();

        InputStream inputStream = urlConnection.getInputStream();
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        this.xmlData = scanner.hasNext() ? scanner.next() : "No data returned";
    }

    public String getData() {
        return this.xmlData;
    }
}
