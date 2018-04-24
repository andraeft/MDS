package com.payit.security.service;

import com.payit.security.model.Credentials;
import com.payit.security.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CredentialsService {
    private final CredentialsRepository repo;

    public void createUser(String username,String password){
        Credentials log = new Credentials(UUID.randomUUID().toString(), username, password);
        repo.save(log);
    }

    @Autowired
    public CredentialsService(CredentialsRepository repo) {
        this.repo = repo;
    }
}
