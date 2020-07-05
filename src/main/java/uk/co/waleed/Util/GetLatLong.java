package uk.co.waleed.Util;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class GetLatLong {

    private String latitude;
    private String longitude;

    public GetLatLong(String city) {
        final String uri = "https://nominatim.openstreetmap.org/search?q=London&format=jsonv2&addressdetails=1";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        JsonParser springParser = JsonParserFactory.getJsonParser();

        List<Object> list = springParser.parseList(result);

        Object object = list.get(1);
        if (object instanceof Map) {
            Map<String,Object> map = (Map<String,Object>) object;
            this.latitude = map.get("lat").toString();
            this.longitude = map.get("lon").toString();
        }
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
