package uk.co.waleed.Util;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class GetCitiesInRadius {
    private String cityName;
    private int radius;

    public GetCitiesInRadius(String cityName, int radius) {
        this.cityName = cityName;
        this.radius = radius;
    }

    public String getData() {
        GetLatLong latLong = new GetLatLong(cityName);

        final String uri = "https://www.freemaptools.com/ajax/get-all-cities-inside.php?lat=51.5073219&lng=-0.1276474&sortaplha=0&radius=80.4672";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        JsonParser springParser = JsonParserFactory.getJsonParser();

        return result;
    }
}
