package uk.co.waleed.Main.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.waleed.Main.Model.HomeDTO;
import uk.co.waleed.Util.GetCitiesInRadius;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HomeController{

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public HomeDTO index() throws IOException {
        GetCitiesInRadius citiesInRadius = new GetCitiesInRadius("London",50);
        System.out.println(citiesInRadius.getData());
        return new HomeDTO(counter.incrementAndGet(),"Welcome");
    }
}
