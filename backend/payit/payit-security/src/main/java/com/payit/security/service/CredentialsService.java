package com.payit.security.service;

import com.payit.common.event.UserRegistered;
import com.payit.security.MyUserDetails;
import com.payit.security.model.Credentials;
import com.payit.security.repository.CredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Qualifier("appUserDetailsService")
@RequiredArgsConstructor
public class CredentialsService implements UserDetailsService {
    private final CredentialsRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher publisher;

    public void createUser(String username, String password){
        String encryptedPassword = passwordEncoder.encode(password);
        Credentials log = new Credentials(UUID.randomUUID().toString(), username, encryptedPassword);
        log = repo.save(log);
        publisher.publishEvent(new UserRegistered(log.getId()));
    }

    @Override
    public UserDetails loadUserByUsername(String s) {
        Credentials c = repo.findByUsername(s);
        if (c == null) throw new UsernameNotFoundException("User not found");
        return new MyUserDetails(c.getUsername(), c.getPassword(), c.getId());
    }
}
