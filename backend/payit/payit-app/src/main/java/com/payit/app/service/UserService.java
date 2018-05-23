package com.payit.app.service;

import com.payit.app.model.User;
import com.payit.app.repository.UserRepository;
import com.payit.security.model.Credentials;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository repo;

    public void createUser(Credentials credential) {
        User newUser = new User();
        newUser.setFkCredentials(credential);
        repo.save(newUser);
    }

    public Collection<User> search(String searchQuery) {
        String[] words = searchQuery.split(" ");
        Set<User> users = new LinkedHashSet<>();
        for (String word : words) {
            users.addAll(repo.findByFkCredentials_Username(word));
            users.addAll(repo.findByEmail(searchQuery));
            users.addAll(repo.findByFirstName(word));
            users.addAll(repo.findByLastName(word));
        }
        return users;
    }
}
