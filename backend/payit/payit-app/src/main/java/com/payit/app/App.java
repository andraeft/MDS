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
        return getResp("Protected: " + UUID.randomUUID().toString());
    }

    @GetMapping(value = "/public")
    public Object publicMethod() {
        return getResp("Public: " + UUID.randomUUID().toString());
    }

    private Object getResp(String msg) {
        Map<String, String> resp = new HashMap<>();
        resp.put("message", msg);
        return resp;
    }
}
