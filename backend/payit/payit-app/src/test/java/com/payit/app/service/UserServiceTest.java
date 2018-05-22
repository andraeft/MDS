package com.payit.app.service;

import com.payit.security.repository.CredentialsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        userService.createUser(credRepo.findAll().get(0));
    }
}