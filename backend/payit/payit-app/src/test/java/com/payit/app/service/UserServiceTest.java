package com.payit.app.service;

import com.payit.app.model.User;
import com.payit.security.model.Credentials;
import com.payit.security.repository.CredentialsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private CredentialsRepository credRepo;

    @Test
    public void createUser() {
        Credentials cred = credRepo.save(new Credentials(UUID.randomUUID().toString(), "test-us", "test-pw"));
        userService.createUser(cred);
    }
    @Test
    public void modifyUser(){
        List<Credentials> l = credRepo.findAll();
        Credentials cred = l.get(l.size() - 1);
        User newUser=userService.createUser(cred);
        userService.modifyUser("ppp@info.ro","Sandu","Ghiulea",newUser.getId());
        User testUser=userService.findById(newUser.getId());
        assertEquals(testUser.getEmail(),"ppp@info.ro");
        assertEquals(testUser.getFirstName(),"Sandu");
        assertEquals(testUser.getLastName(),"Ghiulea");
    }
}