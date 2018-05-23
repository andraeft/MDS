package com.payit.app.service;

import com.payit.app.model.User;
import com.payit.app.repository.UserRepository;
import com.payit.security.model.Credentials;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository repo;

    public User createUser(Credentials credential) {
        User newUser = new User();
        newUser.setFkCredentials(credential);
        return repo.save(newUser);

    }

    @Transactional
    public void modifyUser(String email,String firstName,String lastName,Integer id){
        User modifyUser=repo.findById(id).orElse(null);
        if(modifyUser==null)
            return;
        if(email!=null)
            modifyUser.setEmail(email);
        if(firstName!=null)
            modifyUser.setFirstName(firstName);
        if(lastName!=null)
            modifyUser.setLastName(lastName);
    }

    public User findById(Integer id) {
        return repo.findById(id).orElse(null);
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
