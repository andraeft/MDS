package com.payit.security.exposure;

import com.payit.security.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlExposerController {
    private final CredentialsService serviceOfCredentials;

    @Autowired
    public UrlExposerController(CredentialsService serviceOfCredentials) {
        this.serviceOfCredentials = serviceOfCredentials;
    }

    @PostMapping(value = "/public/credentials")
    public void create(@RequestBody CredentialsDto arg){
        this.serviceOfCredentials.createUser(arg.getUsername(),arg.getPassword());
    }

}
