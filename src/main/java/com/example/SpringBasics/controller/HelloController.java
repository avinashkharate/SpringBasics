package com.example.SpringBasics.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello/{firstName}/{lastName}")
    public ResponseEntity<String> hello(@PathVariable("firstName") String firstName ,@PathVariable("lastName") String lastName ){
        System.out.println("Printing Helooo");
        String response = "Hello "+firstName+lastName;
        return ResponseEntity.ok(response);
    }

    @GetMapping("/greet")
    public ResponseEntity<String> greet(
            @RequestParam(value = "name") String firstName
    ){
        System.out.println("Printing Helooo");
        String response = "Hello "+firstName;

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/home")
    public String showHomePage() {
        // "forward:" tells Spring to look inside the static resources folder
        return "forward:/home.html";
    }
}
