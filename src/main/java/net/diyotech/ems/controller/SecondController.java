package net.diyotech.ems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondController {

    //URL: http:localhost:8082/second/say-bye
    @GetMapping("/say-bye")
    public String sayBye() {
        return "Bye Students";
    }
}
