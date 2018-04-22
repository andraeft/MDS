package com.payit.app;

import com.payit.security.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
@Import({
        SecurityConfig.class
})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping(value = {"/api", "/api/hello"})
    public Object greet() {
        Map<String, String> resp = new HashMap<>();
        resp.put("message", UUID.randomUUID().toString());
        return resp;
    }

    @GetMapping(value = "/public")
    public String publicMethod() {
        return "{\"message\": \"Hello, public\"}";
    }
}
