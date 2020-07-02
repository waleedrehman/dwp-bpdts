package uk.co.waleed.Main.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.waleed.Main.Model.HomeDTO;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HomeController{

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public HomeDTO index() {
        return new HomeDTO(counter.incrementAndGet(),"Welcome");
    }
}
