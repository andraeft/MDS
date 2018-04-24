package com.payit.security.service;

import com.payit.security.MyUserDetails;
import com.payit.security.model.Credentials;
import com.payit.security.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Qualifier("appUserDetailsService")
public class CredentialsService implements UserDetailsService {
    private final CredentialsRepository repo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CredentialsService(CredentialsRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(String username, String password){
        String encryptedPassword = passwordEncoder.encode(password);
        Credentials log = new Credentials(UUID.randomUUID().toString(), username, encryptedPassword);
        repo.save(log);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Credentials c = repo.findByUsername(s);
        if (c == null) throw new UsernameNotFoundException("User not found");
        return new MyUserDetails(c.getUsername(), c.getPassword());
    }
}
