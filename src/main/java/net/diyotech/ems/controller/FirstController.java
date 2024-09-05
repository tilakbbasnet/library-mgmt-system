package net.diyotech.ems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/first")
public class FirstController {

    //Request/Query Parameter
    // URL: http://localhost:8082/first/details?state=Virginia&name=Ram Karki
    @GetMapping("/details")
    public ResponseEntity<String> displayDetails(@RequestParam("name") String fullName, @RequestParam("state") String state) {
        return ResponseEntity.ok().body(fullName+" lives in "+state+".");
    }

    //Path Variable
    // URL: http://localhost:8080/first/say-hi/Ram/23
    @GetMapping("/say-hi/{fullname}/{age}")
    //@RequestMapping(value="/say-hi/{fullname}/{age}", method = RequestMethod.GET)
    public String greetStudent(@PathVariable("fullname") String studentName, @PathVariable("age") Integer age) {
        return "Hello "+studentName+". You are "+age+" years old.";
    }

    // URL: http://localhost:8080/first/say-hi/Ram
    @GetMapping("/say-hi/{name}")
    public String sayHi(@PathVariable("name") String studentName) {
        return "Hello "+studentName;
    }

    // URL: http://localhost:8080/first/say-hello
    @GetMapping("/say-hello")
    public String sayHello() {
        return "Hello Students";
    }
}
