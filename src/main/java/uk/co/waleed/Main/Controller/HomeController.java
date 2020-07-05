package uk.co.waleed.Main.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.waleed.Main.Model.HomeDTO;
import uk.co.waleed.Util.GetCitiesInRadius;
import uk.co.waleed.Util.GetUsersInCities;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HomeController{

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public HomeDTO index(@RequestParam(value="cityName", defaultValue="London") String cityName,@RequestParam(value="radius", defaultValue="50") String radius) throws IOException {
        GetCitiesInRadius citiesInRadius = new GetCitiesInRadius(cityName,Integer.parseInt(radius));
        System.out.println(citiesInRadius.getData());
        GetUsersInCities users = new GetUsersInCities(citiesInRadius.getData());
        return new HomeDTO(counter.incrementAndGet(),users.getData().toString());
    }
}
