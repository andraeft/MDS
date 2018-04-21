package com.payit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping(value = {"/", "/hello"})
    public Object greet() {
        Map<String, String> resp = new HashMap<>();
        resp.put("message", UUID.randomUUID().toString());
        return resp;
    }
}
