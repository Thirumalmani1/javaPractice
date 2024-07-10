package net.javaguides.ems.controller;

import net.javaguides.ems.model.Coffee;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import static java.time.ZoneOffset.UTC;

@RestController
public class CoffeeController {

    private static final LocalDateTime FIXED_DATE = now(UTC).minusDays(1);


    @GetMapping("/coffee")
    public Coffee getCoffee(@RequestParam(name = "brand", required = false) String brand,
                            @RequestParam(name = "name", required = false) String name) {

        return new Coffee(name, brand, FIXED_DATE);
    }
}
