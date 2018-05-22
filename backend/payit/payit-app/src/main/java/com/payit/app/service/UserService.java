package com.payit.app.service;

import com.payit.app.model.User;
import com.payit.app.repository.UserRepository;
import com.payit.security.model.Credentials;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository repo;

    public void createUser(Credentials credential) {
        User newUser = new User();
        newUser.setFkCredentials(credential);
        repo.save(newUser);
    }
}
