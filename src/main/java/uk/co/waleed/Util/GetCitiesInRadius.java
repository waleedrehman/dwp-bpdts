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
    private String cityName;
    private int radius;

    public GetCitiesInRadius(String cityName, int radius) {
        this.cityName = cityName;
        this.radius = radius;
    }

    public String getData() throws IOException {
        GetLatLong latLong = new GetLatLong(cityName);

        URL url = new URL("https://www.freemaptools.com/ajax/get-all-cities-inside.php?lat=51.5073219&lng=-0.1276474&sortaplha=0&radius=80.4672");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Host", "www.freemaptools.com");
        urlConnection.setRequestProperty("Referer", "https://www.freemaptools.com/find-cities-and-towns-inside-radius.htm");

        urlConnection.connect();

        OutputStream outputStream = urlConnection.getOutputStream();
        outputStream.write(("{\"entryId\": \"" + "entryId" + "\"}").getBytes("UTF-8"));
        outputStream.flush();

        InputStream inputStream = urlConnection.getInputStream();
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");

        return scanner.hasNext() ? scanner.next() : "No data returned";
    }
}
